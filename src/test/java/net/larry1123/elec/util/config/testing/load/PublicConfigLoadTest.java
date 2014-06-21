package net.larry1123.elec.util.config.testing.load;

import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.larry1123.elec.util.config.testing.LoadingTestConfigFile;
import net.larry1123.elec.util.factorys.FactoryManager;
import net.larry1123.elec.util.factorys.FieldHandlerFactory;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 6/20/2014 - 11:02 PM
 */
public class PublicConfigLoadTest {

    protected final String loadPath = "target/test-classes/load.cfg";
    protected PropertiesFile loadPropertiesFile = new PropertiesFile(loadPath);
    protected LoadingTestConfigFile configFile = createTestConfigFile(loadPropertiesFile);
    protected final FieldHandlerFactory factory = FactoryManager.getFactoryManager().getMainFieldHandlerFactory();

    @Test
    public void publicBooleanLoad() {
        String fieldName = "publicBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getBoolean(fieldName) == testField.getBoolean(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicBooleanLoad() {
        String fieldName = "PublicBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getBoolean(fieldName) == (Boolean) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicByteLoad() {
        String fieldName = "publicByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getByte(fieldName) == testField.getByte(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicByteLoad() {
        String fieldName = "PublicByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getByte(fieldName) == (Byte) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicByteArrayLoad() {
        String fieldName = "publicByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getByteArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicByteArrayLoad() {
        String fieldName = "PublicByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            byte[] testFieldValue = ArrayUtils.toPrimitive((Byte[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicByteListLoad() {
        String fieldName = "publicByteList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked
            byte[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Byte>) testField.get(configFile)).toArray(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicCharacterLoad() {
        String fieldName = "publicCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getCharacter(fieldName) == testField.getChar(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicCharacterLoad() {
        String fieldName = "PublicCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getCharacter(fieldName) == (Character) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicDoubleLoad() {
        String fieldName = "publicDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getDouble(fieldName) == testField.getDouble(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicDoubleLoad() {
        String fieldName = "PublicDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getDouble(fieldName) == (Double) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicDoubleArrayLoad() {
        String fieldName = "publicDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getDoubleArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicDoubleArrayLoad() {
        String fieldName = "PublicDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            double[] testFieldValue = ArrayUtils.toPrimitive((Double[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicDoubleListLoad() {
        String fieldName = "publicDoubleList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            double[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Double>) testField.get(configFile)).toArray(new Double[((ArrayList<Double>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicFloatLoad() {
        String fieldName = "publicFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getFloat(fieldName) == testField.getFloat(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicFloatLoad() {
        String fieldName = "PublicFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getFloat(fieldName) == (Float) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicFloatArrayLoad() {
        String fieldName = "publicFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getFloatArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicFloatArrayLoad() {
        String fieldName = "PublicFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            float[] testFieldValue = ArrayUtils.toPrimitive((Float[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicFloatListLoad() {
        String fieldName = "publicFloatList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            float[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Float>) testField.get(configFile)).toArray(new Float[((ArrayList<Float>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicLongLoad() {
        String fieldName = "publicLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getLong(fieldName) == testField.getLong(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicLongLoad() {
        String fieldName = "PublicLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getLong(fieldName) == (Long) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicLongArrayLoad() {
        String fieldName = "publicLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getLongArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicLongArrayArrayLoad() {
        String fieldName = "PublicLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            long[] testFieldValue = ArrayUtils.toPrimitive((Long[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicLongListLoad() {
        String fieldName = "publicLongList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            long[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Long>) testField.get(configFile)).toArray(new Long[((ArrayList<Long>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicIntegerLoad() {
        String fieldName = "publicInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getInt(fieldName) == testField.getInt(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicIntegerLoad() {
        String fieldName = "PublicInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getInt(fieldName) == (Integer) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicIntegerArrayLoad() {
        String fieldName = "publicIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getIntArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicIntegerArrayLoad() {
        String fieldName = "PublicIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            int[] testFieldValue = ArrayUtils.toPrimitive((Integer[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicIntegerListLoad() {
        String fieldName = "publicIntegerList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            int[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Integer>) testField.get(configFile)).toArray(new Integer[((ArrayList<Integer>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicShortLoad() {
        String fieldName = "publicShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getShort(fieldName) == testField.getShort(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicShortLoad() {
        String fieldName = "PublicShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getShort(fieldName) == (Short) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicShortArrayLoad() {
        String fieldName = "publicShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getShortArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicShortArrayLoad() {
        String fieldName = "PublicShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            short[] testFieldValue = ArrayUtils.toPrimitive((Short[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicShortListLoad() {
        String fieldName = "publicShortList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            short[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Short>) testField.get(configFile)).toArray(new Short[((ArrayList<Short>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicStringLoad() {
        String fieldName = "publicString";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getString(fieldName).equals(testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicStringArrayLoad() {
        String fieldName = "publicStringArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getStringArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicStringListLoad() {
        String fieldName = "publicStringList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            String[] testFieldValue = ((ArrayList<String>) testField.get(configFile)).toArray(new String[((ArrayList<String>) testField.get(configFile)).size()]);
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getStringArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    protected Field getField(Object ob, String fieldName, Class lastClass) {
        Class currentClass = lastClass == null ? ob.getClass() : lastClass.getSuperclass();
        try {
            Field ret = currentClass.getDeclaredField(fieldName);
            ret.setAccessible(true);
            return ret;
        }
        catch (NoSuchFieldException e) {
            return getField(ob, fieldName, currentClass);
        }
        catch (NullPointerException e) {
            Assert.fail("Can't get field, " + fieldName + ", from ConfigBase!");
            return null;
        }
    }

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = factory.createFieldHandler(testField.getGenericType(), testField, configFile);

        handler.load();
    }

    protected LoadingTestConfigFile createTestConfigFile(final PropertiesFile file) {
        return new LoadingTestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}
