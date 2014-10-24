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
package net.larry1123.elec.util.test.config;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.ConfigField;

import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 10/24/2014 - 1:55 AM
 */
public abstract class FullTestConfigFile implements ConfigBase {

    // Public fields
    @ConfigField
    public boolean publicBoolean = false;
    @ConfigField
    public Boolean PublicBoolean = false;
    @ConfigField
    public byte publicByte = (byte) 541;
    @ConfigField
    public Byte PublicByte = (byte) 509;
    @ConfigField
    public byte[] publicByteArray = new byte[] {(byte) 1, (byte) 6, (byte) 41, (byte) 10, (byte) 999};
    @ConfigField
    public Byte[] PublicByteArray = new Byte[] {(byte) 65, (byte) 15, (byte) 70, (byte) 1010, (byte) 458};
    @ConfigField
    public ArrayList<Byte> PublicByteArrayList = new ArrayList<Byte>();
    @ConfigField
    public char publicCharacter = (char) 550;
    @ConfigField
    public Character PublicCharacter = (char) 560;
    @ConfigField
    public double publicDouble = 59.15891D;
    @ConfigField
    public Double PublicDouble = 991.05D;
    @ConfigField
    public double[] publicDoubleArray = new double[] {455.0, 67.94, 776.2, 1580.5};
    @ConfigField
    public Double[] PublicDoubleArray = new Double[] {448.6, 194.4, 9910.2, 50D};
    @ConfigField
    public ArrayList<Double> PublicDoubleArrayList = new ArrayList<Double>();
    @ConfigField
    public float publicFloat = (float) 688.15;
    @ConfigField
    public Float PublicFloat = (float) 548.1845;
    @ConfigField
    public float[] publicFloatArray = new float[] {(float) 5741.15, (float) 941.191, (float) 9055, (float) 21588};
    @ConfigField
    public Float[] PublicFloatArray = new Float[] {(float) 11.18, (float) 9165.98, (float) 68771, (float) 5411};
    @ConfigField
    public ArrayList<Float> PublicFloatArrayList = new ArrayList<Float>();
    @ConfigField
    public int publicInteger = 5619612;
    @ConfigField
    public Integer PublicInteger = 459687;
    @ConfigField
    public int[] publicIntegerArray = new int[] {1945, 1878, 18710, -8984, 941};
    @ConfigField
    public Integer[] PublicIntegerArray = new Integer[] {981, -800, 98743, 5448, -90};
    @ConfigField
    public ArrayList<Integer> PublicIntegerArrayList = new ArrayList<Integer>();
    @ConfigField
    public long publicLong = 5619L;
    @ConfigField
    public Long PublicLong = 18988L;
    @ConfigField
    public long[] publicLongArray = new long[] {4818L, 48551L, -5195, -541L, 59115L};
    @ConfigField
    public Long[] PublicLongArray = new Long[] {811L, 84441L, 98765L, -888711L, -84L};
    @ConfigField
    public ArrayList<Long> PublicLongArrayList = new ArrayList<Long>();
    @ConfigField
    public short publicShort = 591;
    @ConfigField
    public Short PublicShort = 9144;
    @ConfigField
    public short[] publicShortArray = new short[] {815, -474, 958, 6148, 1889};
    @ConfigField
    public Short[] PublicShortArray = new Short[] {1884, 6248, 6187, 3528, -8474};
    @ConfigField
    public ArrayList<Short> PublicShortArrayList = new ArrayList<Short>();
    @ConfigField
    public String PublicString = "Test String 01";
    @ConfigField
    public String[] PublicStringArray = new String[] {"Test String 20", "Test String 30", "Test String 40", "Test String 50"};
    @ConfigField
    public ArrayList<String> PublicStringArrayList = new ArrayList<String>();

    // Protected Fields
    @ConfigField
    protected boolean protectedBoolean = false;
    @ConfigField
    protected Boolean ProtectedBoolean = false;
    @ConfigField
    protected byte protectedByte = (byte) 5449;
    @ConfigField
    protected Byte ProtectedByte = (byte) 9894;
    @ConfigField
    protected byte[] protectedByteArray = new byte[] {(byte) 9081, (byte) 8540, (byte) -5806, (byte) 901};
    @ConfigField
    protected Byte[] ProtectedByteArray = new Byte[] {(byte) 549, (byte) 871, (byte) -97, (byte) 41856};
    @ConfigField
    protected ArrayList<Byte> ProtectedByteArrayList = new ArrayList<Byte>();
    @ConfigField
    protected char protectedCharacter = 9654;
    @ConfigField
    protected Character ProtectedCharacter = 45598;
    @ConfigField
    protected double protectedDouble = 5781.613;
    @ConfigField
    protected Double ProtectedDouble = 985.15;
    @ConfigField
    protected double[] protectedDoubleArray = new double[] {-56418.2, 54951.591, -5496.0584, 45840};
    @ConfigField
    protected Double[] ProtectedDoubleArray = new Double[] {-5415.18, 854491.5, 45185D, -18.2};
    @ConfigField
    protected ArrayList<Double> ProtectedDoubleArrayList = new ArrayList<Double>();
    @ConfigField
    protected float protectedFloat = 852.85F;
    @ConfigField
    protected Float ProtectedFloat = -845.02F;
    @ConfigField
    protected float[] protectedFloatArray = new float[] {-15F, 5445.0F, 80542.2F, 691.5F};
    @ConfigField
    protected Float[] ProtectedFloatArray = new Float[] {-5846.5F, 5855F, -8515F, 5850.56F};
    @ConfigField
    protected ArrayList<Float> ProtectedFloatArrayList = new ArrayList<Float>();
    @ConfigField
    protected int protectedInteger = -58545;
    @ConfigField
    protected Integer ProtectedInteger = 25491;
    @ConfigField
    protected int[] protectedIntegerArray = new int[] {854, 8584, 9010, 4485, -9515};
    @ConfigField
    protected Integer[] ProtectedIntegerArray = new Integer[] {4941, -8542, 5489, -915, 548};
    @ConfigField
    protected ArrayList<Integer> ProtectedIntegerArrayList = new ArrayList<Integer>();
    @ConfigField
    protected long protectedLong = 9410L;
    @ConfigField
    protected Long ProtectedLong = 8880L;
    @ConfigField
    protected long[] protectedLongArray = new long[] {98L, -910L, 544L, 486L};
    @ConfigField
    protected Long[] ProtectedLongArray = new Long[] {925L, 51150L, -9182L, 6405L};
    @ConfigField
    protected ArrayList<Long> ProtectedLongArrayList = new ArrayList<Long>();
    @ConfigField
    protected short protectedShort = 5180;
    @ConfigField
    protected Short ProtectedShort = -9195;
    @ConfigField
    protected short[] protectedShortArray = new short[] {9815, -8501, 6548, 288, -474};
    @ConfigField
    protected Short[] ProtectedShortArray = new Short[] {8015, -8550, 9812, 35, -892};
    @ConfigField
    protected ArrayList<Short> ProtectedShortArrayList = new ArrayList<Short>();
    @ConfigField
    protected String ProtectedString = "Test String 110";
    @ConfigField
    protected String[] ProtectedStringArray = new String[] {"Test String 120", "Test String 130", "Test String 140"};
    @ConfigField
    protected ArrayList<String> ProtectedStringArrayList = new ArrayList<String>();


    public FullTestConfigFile() {
        PublicByteArrayList.add((byte) 82);
        PublicByteArrayList.add((byte) 85);
        PublicByteArrayList.add((byte) 129);
        PublicByteArrayList.add((byte) 910);
        PublicByteArrayList.add((byte) 858);
        PublicDoubleArrayList.add(558.9);
        PublicDoubleArrayList.add(546.8);
        PublicDoubleArrayList.add(994561.5);
        PublicDoubleArrayList.add(58.0541);
        PublicDoubleArrayList.add(5859.54985);
        PublicFloatArrayList.add((float) 8891.5);
        PublicFloatArrayList.add((float) 981.63);
        PublicFloatArrayList.add((float) 4525.12);
        PublicFloatArrayList.add((float) 49581.96);
        PublicFloatArrayList.add((float) 54561.36);
        PublicIntegerArrayList.add(9884);
        PublicIntegerArrayList.add(871458);
        PublicIntegerArrayList.add(-84);
        PublicIntegerArrayList.add(-915200);
        PublicIntegerArrayList.add(49851);
        PublicLongArrayList.add(89511L);
        PublicLongArrayList.add(2915L);
        PublicLongArrayList.add(-985011L);
        PublicLongArrayList.add(-1105L);
        PublicLongArrayList.add(5410740L);
        PublicShortArrayList.add((short) 1958);
        PublicShortArrayList.add((short) 91125);
        PublicShortArrayList.add((short) 98015);
        PublicShortArrayList.add((short) -15585);
        PublicShortArrayList.add((short) -5488);
        PublicStringArrayList.add("Test String 60");
        PublicStringArrayList.add("Test String 70");
        PublicStringArrayList.add("Test String 80");
        PublicStringArrayList.add("Test String 90");
        PublicStringArrayList.add("Test String 100");

        ProtectedByteArrayList.add((byte) 8645);
        ProtectedByteArrayList.add((byte) 9445);
        ProtectedByteArrayList.add((byte) -51641);
        ProtectedByteArrayList.add((byte) 5158);
        ProtectedByteArrayList.add((byte) 9442);
        ProtectedDoubleArrayList.add(-5458.5);
        ProtectedDoubleArrayList.add(548.042);
        ProtectedDoubleArrayList.add(8985D);
        ProtectedDoubleArrayList.add(-8574.0157);
        ProtectedDoubleArrayList.add(-18054D);
        ProtectedFloatArrayList.add(-5185F);
        ProtectedFloatArrayList.add(548.015F);
        ProtectedFloatArrayList.add(45858.05F);
        ProtectedFloatArrayList.add(591.0885F);
        ProtectedFloatArrayList.add(891.805F);
        ProtectedFloatArrayList.add(9128.0F);
        ProtectedIntegerArrayList.add(-7518);
        ProtectedIntegerArrayList.add(18290);
        ProtectedIntegerArrayList.add(-150200);
        ProtectedIntegerArrayList.add(947124);
        ProtectedIntegerArrayList.add(918550);
        ProtectedLongArrayList.add(9102L);
        ProtectedLongArrayList.add(-8942L);
        ProtectedLongArrayList.add(-8945158L);
        ProtectedLongArrayList.add(514265L);
        ProtectedLongArrayList.add(5615L);
        ProtectedShortArrayList.add((short) -4125);
        ProtectedShortArrayList.add((short) 548120);
        ProtectedShortArrayList.add((short) 9295);
        ProtectedShortArrayList.add((short) -9482);
        ProtectedShortArrayList.add((short) 14058);
        ProtectedStringArrayList.add("Test String 160");
        ProtectedStringArrayList.add("Test String 170");
        ProtectedStringArrayList.add("Test String 180");
        ProtectedStringArrayList.add("Test String 190");
    }

}
