package org.kie.builder.impl;

import org.drools.commons.jci.readers.ResourceReader;
import org.drools.compiler.io.memory.MemoryFileSystem;
import org.kie.builder.GAV;
import org.kie.builder.KieBaseModel;
import org.kie.builder.KieModuleModel;
import org.kie.builder.KieSessionModel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryKieModules extends AbstractKieModule implements ResourceReader {

    private final MemoryFileSystem mfs;
    
    public MemoryKieModules(GAV gav, KieModuleModel kieProject, MemoryFileSystem mfs) {
        super(gav, kieProject);
        this.mfs = mfs;
    }
    
    @Override
    public boolean isAvailable(String path) {
        return mfs.existsFile( path );
    }

    @Override
    public byte[] getBytes(String path) {
        return mfs.getBytes( path );
    }

    @Override
    public Collection<String> getFileNames() {
        return mfs.getFileNames();
    }
    
    public MemoryFileSystem  getMemoryFileSystem() {
        return this.mfs;
    }

    @Override
    public File getFile() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public byte[] getBytes() {
        // TODO Auto-generated method stub
        return null;
    }
}