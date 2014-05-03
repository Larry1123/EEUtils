package net.larry1123.util.config.testing.save;

import net.larry1123.util.config.fieldhanders.FieldHandler;
import net.larry1123.util.config.testing.TestConfigFile;
import net.larry1123.util.factorys.FactoryManager;
import net.larry1123.util.factorys.FieldHandlerFactory;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 1/31/14 - 9:33 AM
 */
@SuppressWarnings("WeakerAccess")
public class PublicConfigSaveTest {

    protected final String savePath = "target/tests/resources/save.cfg";
    protected PropertiesFile savePropertiesFile = new PropertiesFile(savePath);
    protected TestConfigFile configFile = createTestConfigFile(savePropertiesFile);
    protected final FieldHandlerFactory factory = FactoryManager.getFactoryManager().getMainFieldHandlerFactory();

    @Test
    public void publicBooleanSave() {
        String fieldName = "publicBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getBoolean(fieldName) == testField.getBoolean(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicBooleanSave() {
        String fieldName = "PublicBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getBoolean(fieldName) == (Boolean) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicByteSave() {
        String fieldName = "publicByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getByte(fieldName) == testField.getByte(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicByteSave() {
        String fieldName = "PublicByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getByte(fieldName) == (Byte) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicByteArraySave() {
        String fieldName = "publicByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getByteArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicByteArraySave() {
        String fieldName = "PublicByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            byte[] testFieldValue = ArrayUtils.toPrimitive((Byte[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicByteListSave() {
        String fieldName = "publicByteList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked
            byte[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Byte>) testField.get(configFile)).toArray(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicCharacterSave() {
        String fieldName = "publicCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getCharacter(fieldName) == testField.getChar(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicCharacterSave() {
        String fieldName = "PublicCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getCharacter(fieldName) == (Character) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicDoubleSave() {
        String fieldName = "publicDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getDouble(fieldName) == testField.getDouble(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicDoubleSave() {
        String fieldName = "PublicDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getDouble(fieldName) == (Double) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicDoubleArraySave() {
        String fieldName = "publicDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getDoubleArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicDoubleArraySave() {
        String fieldName = "PublicDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            double[] testFieldValue = ArrayUtils.toPrimitive((Double[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicDoubleListSave() {
        String fieldName = "publicDoubleList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            double[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Double>) testField.get(configFile)).toArray(new Double[((ArrayList<Double>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicFloatSave() {
        String fieldName = "publicFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getFloat(fieldName) == testField.getFloat(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicFloatSave() {
        String fieldName = "PublicFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getFloat(fieldName) == (Float) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicFloatArraySave() {
        String fieldName = "publicFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getFloatArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicFloatArraySave() {
        String fieldName = "PublicFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            float[] testFieldValue = ArrayUtils.toPrimitive((Float[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicFloatListSave() {
        String fieldName = "publicFloatList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            float[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Float>) testField.get(configFile)).toArray(new Float[((ArrayList<Float>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicLongSave() {
        String fieldName = "publicLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getLong(fieldName) == testField.getLong(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicLongSave() {
        String fieldName = "PublicLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getLong(fieldName) == (Long) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicLongArraySave() {
        String fieldName = "publicLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getLongArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicLongArrayArraySave() {
        String fieldName = "PublicLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            long[] testFieldValue = ArrayUtils.toPrimitive((Long[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicLongListSave() {
        String fieldName = "publicLongList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            long[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Long>) testField.get(configFile)).toArray(new Long[((ArrayList<Long>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicIntegerSave() {
        String fieldName = "publicInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getInt(fieldName) == testField.getInt(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicIntegerSave() {
        String fieldName = "PublicInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getInt(fieldName) == (Integer) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicIntegerArraySave() {
        String fieldName = "publicIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getIntArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicIntegerArraySave() {
        String fieldName = "PublicIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            int[] testFieldValue = ArrayUtils.toPrimitive((Integer[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicIntegerListSave() {
        String fieldName = "publicIntegerList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            int[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Integer>) testField.get(configFile)).toArray(new Integer[((ArrayList<Integer>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicShortSave() {
        String fieldName = "publicShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getShort(fieldName) == testField.getShort(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicShortSave() {
        String fieldName = "PublicShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getShort(fieldName) == (Short) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicShortArraySave() {
        String fieldName = "publicShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getShortArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void PublicShortArraySave() {
        String fieldName = "PublicShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            short[] testFieldValue = ArrayUtils.toPrimitive((Short[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicShortListSave() {
        String fieldName = "publicShortList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            short[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Short>) testField.get(configFile)).toArray(new Short[((ArrayList<Short>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicStringSave() {
        String fieldName = "publicString";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getString(fieldName).equals(testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicStringArraySave() {
        String fieldName = "publicStringArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getStringArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void publicStringListSave() {
        String fieldName = "publicStringList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            String[] testFieldValue = ((ArrayList<String>) testField.get(configFile)).toArray(new String[((ArrayList<String>) testField.get(configFile)).size()]);
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getStringArray(fieldName), testFieldValue));
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

        handler.save();
        savePropertiesFile.save();
    }

    protected TestConfigFile createTestConfigFile(final PropertiesFile file) {
        return new TestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}
