/*
 * Copyright 2011 Holger Brandl
 *
 * This code is licensed under BSD. For details see
 * http://www.opensource.org/licenses/bsd-license.php
 */

package com.r4intellij.misc.rinstallcache;

import java.io.Serializable;
import java.util.*;


/**
 * A cached description of an r-package
 *
 * @author Holger Brandl
 */
public class RPackage implements Serializable {

    private static final long serialVersionUID = -55199278816509760L;

    private final String packageName;
    private final Set<Function> functions;
    private final String packageVersion;
    private final Collection<String> dependencies;


    public RPackage(String packageName, List<Function> functions, String packageVersion, List<String> dependencies) {

        this.packageName = packageName;
        this.functions = new HashSet<Function>(functions);
        this.packageVersion = packageVersion;
        this.dependencies = dependencies;
    }


    public String getName() {
        return packageName;
    }


    public String getVersion() {
        return packageVersion;
    }


    public Collection<Function> getFunctions() {
        return Collections.unmodifiableCollection(functions);
    }


    public boolean hasFunction(String funName) {
        for (Function function : functions) {
            if (function.getFunName().equals(funName)) {
                return true;
            }
        }

        return false;
    }


    public Function getFunction(String funName) {
        for (Function function : functions) {
            if (function.getFunName().equals(funName)) {
                return function;
            }
        }

        return null;
    }


    public Collection<String> getDependencyNames() {
        return dependencies;
    }


    public Collection<RPackage> getDependencies(LibIndex packageIndex) {
        Collection<RPackage> deps = new HashSet<RPackage>();

        for (String dep : getDependencyNames()) {
            RPackage depPckg = packageIndex.getByName(dep);
            if (depPckg == null)
                continue;

            deps.add(depPckg);
        }

        return deps;
    }


    public boolean isDummy() {
        return functions.isEmpty();
    }


    @Override
    public String toString() {
        return packageName + " (" + packageVersion + ")";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RPackage rPackage = (RPackage) o;

        if (!packageName.equals(rPackage.packageName)) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return packageName.hashCode();
    }
}
