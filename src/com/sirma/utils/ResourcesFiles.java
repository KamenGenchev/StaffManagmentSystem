package com.sirma.utils;

import java.io.File;
import java.util.Objects;

public class ResourcesFiles {
    public static final File EMPLOYEES_CSV = new File(Objects.requireNonNull(ResourcesFiles.class.getResource("employees.csv")).getPath());
    public static final File EMPLOYEES_JSON = new File(Objects.requireNonNull(ResourcesFiles.class.getResource("employees.json")).getPath());
}
