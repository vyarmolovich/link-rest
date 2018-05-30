package io.swagger.codegen.languages;

import com.google.common.base.Strings;
import io.swagger.codegen.CliOption;
import io.swagger.codegen.CodegenModel;
import io.swagger.codegen.CodegenOperation;
import io.swagger.codegen.CodegenParameter;
import io.swagger.codegen.CodegenProperty;
import io.swagger.codegen.languages.features.LinkRestServerFeatures;
import io.swagger.models.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LinkRestServerCodegen extends AbstractJavaJAXRSServerCodegen implements LinkRestServerFeatures {
    private static final Logger LOGGER = LoggerFactory.getLogger(io.swagger.codegen.languages.LinkRestServerCodegen.class);

    private final Map<String, Set<CodegenProperty>> models = new HashMap<>();

    protected boolean generateForTesting = false;

    public LinkRestServerCodegen() {
        super();
        artifactId = "swagger-jaxrs-linkrest-server";

        supportsInheritance = true;
        sourceFolder = "src/main/java";
        implFolder = "src/main/java";
        testFolder = "src/test/java";

        outputFolder = "generated-code/JavaJaxRS-LinkRest";

        apiTestTemplateFiles.clear();

        modelDocTemplateFiles.remove("model_doc.mustache");
        apiDocTemplateFiles.remove("api_doc.mustache");


        typeMapping.put("date", "LocalDateTime");
        importMapping.put("LocalDate", "java.time.LocalDateTime");
        importMapping.put("LocalDateTime", "java.time.LocalDateTime");
        typeMapping.put("DateTime", "LocalDateTime");
        typeMapping.put("number", "Double");

        embeddedTemplateDir = templateDir = AbstractJavaJAXRSServerCodegen.JAXRS_TEMPLATE_DIRECTORY_NAME + File.separator + "linkrest";

        cliOptions.add(CliOption.newBoolean(GENERATE_FOR_TESTING, "Generates models and API's for testing purpose"));
    }

    @Override
    public String getName() {
        return "linkrest";
    }

    @Override
    public String getHelp() {
        return "Generates LinkRest jaxrs API.";
    }

    @Override
    public void processOpts() {
        super.processOpts();

        if (additionalProperties.containsKey(GENERATE_FOR_TESTING)) {
            this.setGenerateForTesting(convertPropertyToBooleanAndWriteBack(GENERATE_FOR_TESTING));
        }
    }

    @Override
    public void addOperationToGroup(String tag, String resourcePath, Operation operation, CodegenOperation co, Map<String, List<CodegenOperation>> operations) {
        super.addOperationToGroup(tag, resourcePath, operation, co, operations);
        co.subresourceOperation = !co.path.isEmpty();
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        if (!Strings.isNullOrEmpty(model.classname)) {
            Set<CodegenProperty> props = models.get(model.classname);
            if (props == null) {
                props = new HashSet<>();
            }
            props.add(property);
            models.put(model.classname, props);
        }
    }

    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        Map<String, Object> objsResult = super.postProcessOperations(objs);

        Map<String, Object> operations = (Map<String, Object>) objsResult.get("operations");

        if ( operations != null ) {
            @SuppressWarnings("unchecked")
            List<CodegenOperation> ops = (List<CodegenOperation>) operations.get("operation");
            for ( CodegenOperation operation : ops ) {
                // Remove containers from response
                if ( operation.returnBaseType != null && operation.returnType.startsWith("List") ) {
                    if (operation.returnType.contains(">")) {
                        operation.returnType = operation.baseName;
                        operation.returnContainer = "List";
                    }
                }

                // Stores model properties as header parameters to use them as constraints
                if (models.get(operation.baseName) != null) {
                    for (final CodegenProperty prop : models.get(operation.baseName)) {
                        final CodegenParameter codegenParam = new CodegenParameter();
                        codegenParam.paramName = prop.baseName;
                        operation.headerParams.add(codegenParam);
                    }
                }
            }
        }

        return objsResult;
    }

    @Override
    public String toApiName(String name) {
        if (name.length() == 0) {
            return "DefaultApi";
        }
        return camelize(name) + "Resource";
    }

    @Override
    public String apiFileFolder() {
        if (generateForTesting) {
            implFolder = testFolder;
            return super.apiTestFileFolder();
        }
        return super.apiFileFolder();
    }

    @Override
    public String modelFileFolder() {
        if (generateForTesting) {
            return outputFolder + "/" + testFolder + "/" + modelPackage().replace('.', '/');
        }
        return super.modelFileFolder();
    }

    @Override
    public void setGenerateForTesting(boolean generateForTesting) {
        this.generateForTesting = generateForTesting;
    }
}

