/*
 * Copyright 2014 ElecEntertainment
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.larry1123.elec.util.test.config.save;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.ConfigField;

import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 1/31/14 - 9:02 AM
 */
@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "MismatchedReadAndWriteOfArray"})
public abstract class TestConfigFile implements ConfigBase {

    @ConfigField
    public boolean publicBoolean = true;

    // Public fields
    @ConfigField
    public Boolean PublicBoolean = true;
    @ConfigField
    public byte publicByte = (byte) 51;
    @ConfigField
    public Byte PublicByte = (byte) 55;
    @ConfigField
    public byte[] publicByteArray = new byte[] {(byte) 0, (byte) 5, (byte) 6, (byte) 100, (byte) 99};
    @ConfigField
    public Byte[] PublicByteArray = new Byte[] {(byte) 1, (byte) 4, (byte) 7, (byte) 101, (byte) 98};
    @ConfigField
    public ArrayList<Byte> PublicByteArrayList = new ArrayList<Byte>();
    @ConfigField
    public char publicCharacter = (char) 52;
    @ConfigField
    public Character PublicCharacter = (char) 56;
    @ConfigField
    public double publicDouble = 519.15891D;
    @ConfigField
    public Double PublicDouble = 991.059D;
    @ConfigField
    public double[] publicDoubleArray = new double[] {45.0, 67.9, 77.2, 150.5};
    @ConfigField
    public Double[] PublicDoubleArray = new Double[] {48.6, 94.4, 991.2, 5D};
    @ConfigField
    public ArrayList<Double> PublicDoubleArrayList = new ArrayList<Double>();
    @ConfigField
    public float publicFloat = (float) 68.15;
    @ConfigField
    public Float PublicFloat = (float) 548.185;
    @ConfigField
    public float[] publicFloatArray = new float[] {(float) 541.15, (float) 941.91, (float) 905, (float) 2158};
    @ConfigField
    public Float[] PublicFloatArray = new Float[] {(float) 115.18, (float) 91165.98, (float) 8771, (float) 511};
    @ConfigField
    public ArrayList<Float> PublicFloatArrayList = new ArrayList<Float>();
    @ConfigField
    public int publicInteger = 56159612;
    @ConfigField
    public Integer PublicInteger = 4591687;
    @ConfigField
    public int[] publicIntegerArray = new int[] {195, 19878, 187110, -894, 8941};
    @ConfigField
    public Integer[] PublicIntegerArray = new Integer[] {9811, -8100, 98743, 548, -9};
    @ConfigField
    public ArrayList<Integer> PublicIntegerArrayList = new ArrayList<Integer>();
    @ConfigField
    public long publicLong = 56919L;
    @ConfigField
    public Long PublicLong = 189588L;
    @ConfigField
    public long[] publicLongArray = new long[] {818L, 4851L, 95195, -5481L, 9115L};
    @ConfigField
    public Long[] PublicLongArray = new Long[] {8511L, 8441L, 987465L, -8711L, -874L};
    @ConfigField
    public ArrayList<Long> PublicLongArrayList = new ArrayList<Long>();
    @ConfigField
    public short publicShort = 5961;
    @ConfigField
    public Short PublicShort = 9145;
    @ConfigField
    public short[] publicShortArray = new short[] {81, -47, 95, 648, 188};
    @ConfigField
    public Short[] PublicShortArray = new Short[] {184, 648, 187, 328, -874};
    @ConfigField
    public ArrayList<Short> PublicShortArrayList = new ArrayList<Short>();
    @ConfigField
    public String PublicString = "Test String 1";
    @ConfigField
    public String[] PublicStringArray = new String[] {"Test String 2", "Test String 3", "Test String 4", "Test String 5"};
    @ConfigField
    public ArrayList<String> PublicStringArrayList = new ArrayList<String>();

    // Protected Fields
    @ConfigField
    protected boolean protectedBoolean = true;
    @ConfigField
    protected Boolean ProtectedBoolean = true;
    @ConfigField
    protected byte protectedByte = (byte) 549;
    @ConfigField
    protected Byte ProtectedByte = (byte) 984;
    @ConfigField
    protected byte[] protectedByteArray = new byte[] {(byte) 981, (byte) 854, (byte) -586, (byte) 91};
    @ConfigField
    protected Byte[] ProtectedByteArray = new Byte[] {(byte) 549, (byte) 871, (byte) -987, (byte) 4156};
    @ConfigField
    protected ArrayList<Byte> ProtectedByteArrayList = new ArrayList<Byte>();
    @ConfigField
    protected char protectedCharacter = 9654;
    @ConfigField
    protected Character ProtectedCharacter = 4598;
    @ConfigField
    protected double protectedDouble = 5781.63;
    @ConfigField
    protected Double ProtectedDouble = 9845.15;
    @ConfigField
    protected double[] protectedDoubleArray = new double[] {-5618.2, 54951.91, -5496.054, 4584};
    @ConfigField
    protected Double[] ProtectedDoubleArray = new Double[] {-54185.18, 85491.5, 4185D, -198.2};
    @ConfigField
    protected ArrayList<Double> ProtectedDoubleArrayList = new ArrayList<Double>();
    @ConfigField
    protected float protectedFloat = 8542.85F;
    @ConfigField
    protected Float ProtectedFloat = -845.2F;
    @ConfigField
    protected float[] protectedFloatArray = new float[] {-155F, 545.0F, 8542.2F, 6912.5F};
    @ConfigField
    protected Float[] ProtectedFloatArray = new Float[] {-546.5F, 58455F, -515F, 54850.56F};
    @ConfigField
    protected ArrayList<Float> ProtectedFloatArrayList = new ArrayList<Float>();
    @ConfigField
    protected int protectedInteger = -8545;
    @ConfigField
    protected Integer ProtectedInteger = 5491;
    @ConfigField
    protected int[] protectedIntegerArray = new int[] {84, 854, 910, 485, -515};
    @ConfigField
    protected Integer[] ProtectedIntegerArray = new Integer[] {941, -842, 548, -9155, 5481};
    @ConfigField
    protected ArrayList<Integer> ProtectedIntegerArrayList = new ArrayList<Integer>();
    @ConfigField
    protected long protectedLong = 910L;
    @ConfigField
    protected Long ProtectedLong = 880L;
    @ConfigField
    protected long[] protectedLongArray = new long[] {981L, -91L, 584L, 66L};
    @ConfigField
    protected Long[] ProtectedLongArray = new Long[] {9125L, 5110L, -912L, 645L};
    @ConfigField
    protected ArrayList<Long> ProtectedLongArrayList = new ArrayList<Long>();
    @ConfigField
    protected short protectedShort = 510;
    @ConfigField
    protected Short ProtectedShort = -915;
    @ConfigField
    protected short[] protectedShortArray = new short[] {915, -851, 658, 28, -74};
    @ConfigField
    protected Short[] ProtectedShortArray = new Short[] {815, -850, 912, 315, -912};
    @ConfigField
    protected ArrayList<Short> ProtectedShortArrayList = new ArrayList<Short>();
    @ConfigField
    protected String ProtectedString = "Test String 11";
    @ConfigField
    protected String[] ProtectedStringArray = new String[] {"Test String 12", "Test String 13", "Test String 14"};
    @ConfigField
    protected ArrayList<String> ProtectedStringArrayList = new ArrayList<String>();

    public TestConfigFile() {
        PublicByteArrayList.add((byte) 2);
        PublicByteArrayList.add((byte) 8);
        PublicByteArrayList.add((byte) 12);
        PublicByteArrayList.add((byte) 91);
        PublicByteArrayList.add((byte) 85);
        PublicDoubleArrayList.add(58.9);
        PublicDoubleArrayList.add(5456.8);
        PublicDoubleArrayList.add(9984561.5);
        PublicDoubleArrayList.add(581.0541);
        PublicDoubleArrayList.add(58459.54985);
        PublicFloatArrayList.add((float) 891.5);
        PublicFloatArrayList.add((float) 1981.63);
        PublicFloatArrayList.add((float) 45.12);
        PublicFloatArrayList.add((float) 4581.96);
        PublicFloatArrayList.add((float) 5461.36);
        PublicIntegerArrayList.add(984);
        PublicIntegerArrayList.add(87458);
        PublicIntegerArrayList.add(-841);
        PublicIntegerArrayList.add(-9120000);
        PublicIntegerArrayList.add(4981651);
        PublicLongArrayList.add(9511L);
        PublicLongArrayList.add(915L);
        PublicLongArrayList.add(-98511L);
        PublicLongArrayList.add(-110L);
        PublicLongArrayList.add(54100L);
        PublicShortArrayList.add((short) 198);
        PublicShortArrayList.add((short) 9125);
        PublicShortArrayList.add((short) 9815);
        PublicShortArrayList.add((short) -1585);
        PublicShortArrayList.add((short) -548);
        PublicStringArrayList.add("Test String 6");
        PublicStringArrayList.add("Test String 7");
        PublicStringArrayList.add("Test String 8");
        PublicStringArrayList.add("Test String 9");
        PublicStringArrayList.add("Test String 10");

        ProtectedByteArrayList.add((byte) 845);
        ProtectedByteArrayList.add((byte) 945);
        ProtectedByteArrayList.add((byte) -5641);
        ProtectedByteArrayList.add((byte) 515);
        ProtectedByteArrayList.add((byte) 942);
        ProtectedDoubleArrayList.add(-548.5);
        ProtectedDoubleArrayList.add(548.02);
        ProtectedDoubleArrayList.add(895D);
        ProtectedDoubleArrayList.add(-8574.057);
        ProtectedDoubleArrayList.add(-1854D);
        ProtectedFloatArrayList.add(-515F);
        ProtectedFloatArrayList.add(548.05F);
        ProtectedFloatArrayList.add(4585.05F);
        ProtectedFloatArrayList.add(591.05F);
        ProtectedFloatArrayList.add(891.05F);
        ProtectedFloatArrayList.add(918.0F);
        ProtectedIntegerArrayList.add(-518);
        ProtectedIntegerArrayList.add(1820);
        ProtectedIntegerArrayList.add(-1200);
        ProtectedIntegerArrayList.add(94124);
        ProtectedIntegerArrayList.add(91550);
        ProtectedLongArrayList.add(912L);
        ProtectedLongArrayList.add(-942L);
        ProtectedLongArrayList.add(-945158L);
        ProtectedLongArrayList.add(51265L);
        ProtectedLongArrayList.add(515L);
        ProtectedShortArrayList.add((short) -125);
        ProtectedShortArrayList.add((short) 54120);
        ProtectedShortArrayList.add((short) 995);
        ProtectedShortArrayList.add((short) -942);
        ProtectedShortArrayList.add((short) 1058);
        ProtectedStringArrayList.add("Test String 16");
        ProtectedStringArrayList.add("Test String 17");
        ProtectedStringArrayList.add("Test String 18");
        ProtectedStringArrayList.add("Test String 19");
    }

}
