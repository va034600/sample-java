package com.my.company.codegen;

import io.swagger.codegen.v3.generators.typescript.AbstractTypeScriptClientCodegen;

public class MyTypescriptGenerator extends AbstractTypeScriptClientCodegen {
    public MyTypescriptGenerator() {
        super();

        this.modelTemplateFiles.put("model.mustache", ".ts");
        this.apiTemplateFiles.put("api.mustache", ".ts");
        this.apiPackage = "API.Client1";
        this.modelPackage = "API.Client2";
//        this.supportingFiles.add(new SupportingFile("api.d.mustache", apiPackage().replaceAll(".\", "${File.separatorChar}"), "api.d.ts"));
        this.typeMapping.put("DateTime", "string");
    }

    @Override
    public String getDefaultTemplateDir() {
        return "myClientCodegen";
    }

    @Override
    public String getName() {
        return "my-typescript";
    }

    @Override
    public String getHelp() {
        return "Custom Typescript code generator";
    }
}
