package com.nhl.link.rest.it.fixture.cayenne.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.nhl.link.rest.it.fixture.cayenne.E14;

/**
 * Class _E15 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _E15 extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    @Deprecated
    public static final String NAME_PROPERTY = "name";
    @Deprecated
    public static final String E14S_PROPERTY = "e14s";

    public static final String LONG_ID_PK_COLUMN = "long_id";

    public static final Property<String> NAME = new Property<String>("name");
    public static final Property<List<E14>> E14S = new Property<List<E14>>("e14s");

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void addToE14s(E14 obj) {
        addToManyTarget("e14s", obj, true);
    }
    public void removeFromE14s(E14 obj) {
        removeToManyTarget("e14s", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<E14> getE14s() {
        return (List<E14>)readProperty("e14s");
    }


}