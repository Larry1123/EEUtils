package net.larry1123.elec.util.config.fieldhanders.bytes;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 2:47 AM
 */
public class ByteArrayWrapFieldHandler extends ArrayFieldHandler<Byte[]> {

    public ByteArrayWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public ByteArrayWrapFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Byte[] value) {
        if (ArrayUtils.isNotEmpty(value)) {
            byte[] temp = ArrayUtils.toPrimitive(value);
            getPropertiesFile().setByteArray(getKey(), temp, getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte[] getFromFile() {
        if (getPropertiesFile().containsKey(getKey())) {
            byte[] temp = getPropertiesFile().getByteArray(getKey(), getSpacer());
            return ArrayUtils.toObject(temp);
        }
        else {
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
