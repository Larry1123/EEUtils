package net.larry1123.elec.util.test;

import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.factorys.FactoryManager;
import net.larry1123.elec.util.factorys.FieldHandlerFactory;
import net.larry1123.elec.util.factorys.ParameterizedTypeFactory;
import net.larry1123.elec.util.logger.EELogger;

/**
 * @author Larry1123
 * @since 10/23/2014 - 8:08 PM
 */
public class AbstractTestClass {

    protected final String name;

    public AbstractTestClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FactoryManager getFactoryManager() {
        return FactoryManager.getFactoryManager();
    }

    public FieldHandlerFactory getFieldHandlerFactory() {
        return getFactoryManager().getMainFieldHandlerFactory();
    }

    public ParameterizedTypeFactory getParameterizedTypeFactory() {
        return getFactoryManager().getParameterizedTypeFactory();
    }

    public EELoggerFactory getEELoggerFactory() {
        return getFactoryManager().getEELoggerFactory();
    }

    public EELogger getLogger() {
        return getEELoggerFactory().getLogger(getName());
    }

    public EELogger getLogger(String sub) {
        return getEELoggerFactory().getSubLogger(sub, getLogger());
    }

}
