package com.sirma.manager;

public abstract class Manager {
    protected final Service service;

    public Manager(Service service) {
        this.service = service;
    }

    public abstract void execute(int command);
}
