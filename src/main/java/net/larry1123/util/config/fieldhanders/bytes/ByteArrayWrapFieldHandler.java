package net.larry1123.util.config.fieldhanders.bytes;

import net.larry1123.util.config.ConfigBase;
import net.larry1123.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 2:47 AM
 */
public class ByteArrayWrapFieldHandler extends ArrayFieldHandler<Byte[]> {

    public ByteArrayWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);
    }

    public ByteArrayWrapFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Byte[] value) {
        byte[] temp = ArrayUtils.toPrimitive(value);
        getPropertiesFile().setByteArray(getFieldName(), temp, getSpacer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte[] getFromFile() {
        try {
            byte[] temp = getPropertiesFile().getByteArray(getFieldName(), getSpacer());
            return ArrayUtils.toObject(temp);
        }
        catch (UtilityException utilityException) {
            return new Byte[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte[] getFromField() {
        try {
            return (Byte[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new Byte[0];
        }
    }

}
