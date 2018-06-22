package com.nhl.link.rest.runtime.parser.tree;

import com.nhl.link.rest.ResourceEntity;

import java.util.List;

/**
 * @since 2.13
 */
public interface IIncludeProcessor {

    void process(ResourceEntity<?> resourceEntity, List<String> includes);
}