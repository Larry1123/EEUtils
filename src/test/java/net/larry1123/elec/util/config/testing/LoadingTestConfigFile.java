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
package net.larry1123.elec.util.config.testing;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.ConfigField;

import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 6/20/2014 - 10:48 PM
 */
public abstract class LoadingTestConfigFile implements ConfigBase {

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
    public ArrayList<Byte> publicByteList = new ArrayList<Byte>();
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
    public ArrayList<Double> publicDoubleList = new ArrayList<Double>();
    @ConfigField
    public float publicFloat = (float) 688.15;
    @ConfigField
    public Float PublicFloat = (float) 548.1845;
    @ConfigField
    public float[] publicFloatArray = new float[] {(float) 5741.15, (float) 941.191, (float) 9055, (float) 21588};
    @ConfigField
    public Float[] PublicFloatArray = new Float[] {(float) 11.18, (float) 9165.98, (float) 68771, (float) 5411};
    @ConfigField
    public ArrayList<Float> publicFloatList = new ArrayList<Float>();
    @ConfigField
    public int publicInteger = 5619612;
    @ConfigField
    public Integer PublicInteger = 459687;
    @ConfigField
    public int[] publicIntegerArray = new int[] {1945, 1878, 18710, -8984, 941};
    @ConfigField
    public Integer[] PublicIntegerArray = new Integer[] {981, -800, 98743, 5448, -90};
    @ConfigField
    public ArrayList<Integer> publicIntegerList = new ArrayList<Integer>();
    @ConfigField
    public long publicLong = 5619L;
    @ConfigField
    public Long PublicLong = 18988L;
    @ConfigField
    public long[] publicLongArray = new long[] {4818L, 48551L, -5195, -541L, 59115L};
    @ConfigField
    public Long[] PublicLongArray = new Long[] {811L, 84441L, 98765L, -888711L, -84L};
    @ConfigField
    public ArrayList<Long> publicLongList = new ArrayList<Long>();
    @ConfigField
    public short publicShort = 591;
    @ConfigField
    public Short PublicShort = 9144;
    @ConfigField
    public short[] publicShortArray = new short[] {815, -474, 958, 6148, 1889};
    @ConfigField
    public Short[] PublicShortArray = new Short[] {1884, 6248, 6187, 3528, -8474};
    @ConfigField
    public ArrayList<Short> publicShortList = new ArrayList<Short>();
    @ConfigField
    public String publicString = "Test String 01";
    @ConfigField
    public String[] publicStringArray = new String[] {"Test String 20", "Test String 30", "Test String 40", "Test String 50"};
    @ConfigField
    public ArrayList<String> publicStringList = new ArrayList<String>();

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
    protected ArrayList<Byte> protectedByteList = new ArrayList<Byte>();
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
    protected ArrayList<Double> protectedDoubleList = new ArrayList<Double>();
    @ConfigField
    protected float protectedFloat = 852.85F;
    @ConfigField
    protected Float ProtectedFloat = -845.02F;
    @ConfigField
    protected float[] protectedFloatArray = new float[] {-15F, 5445.0F, 80542.2F, 691.5F};
    @ConfigField
    protected Float[] ProtectedFloatArray = new Float[] {-5846.5F, 5855F, -8515F, 5850.56F};
    @ConfigField
    protected ArrayList<Float> protectedFloatList = new ArrayList<Float>();
    @ConfigField
    protected int protectedInteger = -58545;
    @ConfigField
    protected Integer ProtectedInteger = 25491;
    @ConfigField
    protected int[] protectedIntegerArray = new int[] {854, 8584, 9010, 4485, -9515};
    @ConfigField
    protected Integer[] ProtectedIntegerArray = new Integer[] {4941, -8542, 5489, -915, 548};
    @ConfigField
    protected ArrayList<Integer> protectedIntegerList = new ArrayList<Integer>();
    @ConfigField
    protected long protectedLong = 9410L;
    @ConfigField
    protected Long ProtectedLong = 8880L;
    @ConfigField
    protected long[] protectedLongArray = new long[] {98L, -910L, 544L, 486L};
    @ConfigField
    protected Long[] ProtectedLongArray = new Long[] {925L, 51150L, -9182L, 6405L};
    @ConfigField
    protected ArrayList<Long> protectedLongList = new ArrayList<Long>();
    @ConfigField
    protected short protectedShort = 5180;
    @ConfigField
    protected Short ProtectedShort = -9195;
    @ConfigField
    protected short[] protectedShortArray = new short[] {9815, -8501, 6548, 288, -474};
    @ConfigField
    protected Short[] ProtectedShortArray = new Short[] {8015, -8550, 9812, 35, -892};
    @ConfigField
    protected ArrayList<Short> protectedShortList = new ArrayList<Short>();
    @ConfigField
    protected String protectedString = "Test String 110";
    @ConfigField
    protected String[] protectedStringArray = new String[] {"Test String 120", "Test String 130", "Test String 140"};
    @ConfigField
    protected ArrayList<String> protectedStringList = new ArrayList<String>();


    public LoadingTestConfigFile() {
        publicByteList.add((byte) 82);
        publicByteList.add((byte) 85);
        publicByteList.add((byte) 129);
        publicByteList.add((byte) 910);
        publicByteList.add((byte) 858);
        publicDoubleList.add(558.9);
        publicDoubleList.add(546.8);
        publicDoubleList.add(994561.5);
        publicDoubleList.add(58.0541);
        publicDoubleList.add(5859.54985);
        publicFloatList.add((float) 8891.5);
        publicFloatList.add((float) 981.63);
        publicFloatList.add((float) 4525.12);
        publicFloatList.add((float) 49581.96);
        publicFloatList.add((float) 54561.36);
        publicIntegerList.add(9884);
        publicIntegerList.add(871458);
        publicIntegerList.add(-84);
        publicIntegerList.add(-915200);
        publicIntegerList.add(49851);
        publicLongList.add(89511L);
        publicLongList.add(2915L);
        publicLongList.add(-985011L);
        publicLongList.add(-1105L);
        publicLongList.add(5410740L);
        publicShortList.add((short) 1958);
        publicShortList.add((short) 91125);
        publicShortList.add((short) 98015);
        publicShortList.add((short) -15585);
        publicShortList.add((short) -5488);
        publicStringList.add("Test String 60");
        publicStringList.add("Test String 70");
        publicStringList.add("Test String 80");
        publicStringList.add("Test String 90");
        publicStringList.add("Test String 100");

        protectedByteList.add((byte) 8645);
        protectedByteList.add((byte) 9445);
        protectedByteList.add((byte) -51641);
        protectedByteList.add((byte) 5158);
        protectedByteList.add((byte) 9442);
        protectedDoubleList.add(-5458.5);
        protectedDoubleList.add(548.042);
        protectedDoubleList.add(8985D);
        protectedDoubleList.add(-8574.0157);
        protectedDoubleList.add(-18054D);
        protectedFloatList.add(-5185F);
        protectedFloatList.add(548.015F);
        protectedFloatList.add(45858.05F);
        protectedFloatList.add(591.0885F);
        protectedFloatList.add(891.805F);
        protectedFloatList.add(9128.0F);
        protectedIntegerList.add(-7518);
        protectedIntegerList.add(18290);
        protectedIntegerList.add(-150200);
        protectedIntegerList.add(947124);
        protectedIntegerList.add(918550);
        protectedLongList.add(9102L);
        protectedLongList.add(-8942L);
        protectedLongList.add(-8945158L);
        protectedLongList.add(514265L);
        protectedLongList.add(5615L);
        protectedShortList.add((short) -4125);
        protectedShortList.add((short) 548120);
        protectedShortList.add((short) 9295);
        protectedShortList.add((short) -9482);
        protectedShortList.add((short) 14058);
        protectedStringList.add("Test String 160");
        protectedStringList.add("Test String 170");
        protectedStringList.add("Test String 180");
        protectedStringList.add("Test String 190");
    }

}
