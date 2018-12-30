import java.util.*;

public class Contest3 {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int in : nums) min = Math.min(in, min);

        int sum = 0;
        for (int in : nums) sum += in - min;
        return sum;
    }

    public static void main(String[] args) {
        Contest3 c = new Contest3();
        System.out.println(c.numberOfBoomerangs(new int[][]
                {{3327,-549},{9196,-8118},{7610,-9506},{5098,8392},{8582,7953},{1053,5802},{3847,2652},{7654,8355},{1614,-9409},{9986,5538},{4660,2944},{4528,-9512},{7483,-1455},{3422,-3966},{2037,-4456},{5107,-4635},{4996,655},{7247,2606},{1149,8697},{7350,6083},{3002,8403},{8238,6850},{1055,5892},{5205,9021},{2835,5191},{911,-2505},{4488,-4561},{7983,-1677},{336,-2243},{4358,-1274},{3302,9465},{4091,-5350},{120,7690},{3608,7622},{6388,-9042},{57,-610},{9361,8295},{6240,-3232},{540,7797},{2141,-6625},{9341,3053},{7223,3829},{4844,1558},{2152,-8467},{9316,6510},{259,-1030},{2327,-5650},{9972,8800},{2040,-6420},{2774,4780},{4538,-7169},{4171,-6101},{7479,-3237},{7019,-1981},{4561,-4488},{7746,254},{4917,4969},{4083,-238},{6528,-7413},{1295,-7804},{5450,-8446},{1166,-5871},{2256,-8862},{2929,-5704},{4718,2055},{5429,-4392},{4887,9600},{9507,-1282},{2715,2878},{6737,-6372},{8390,-9165},{3882,3308},{5805,4317},{9422,8685},{3257,-2931},{881,-1293},{8623,-1601},{2836,879},{5889,2118},{1527,607},{4173,-3044},{6215,5412},{2908,-7926},{4130,-8024},{1304,7219},{1956,-3954},{8055,5839},{5706,212},{6508,5128},{8897,9765},{2197,-3870},{8472,-2828},{4529,7661},{4403,-9582},{6131,-7717},{7377,-3344},{5591,9944},{2069,-5148},{8370,-7449},{6828,-3974},{6123,-1216},{2072,530},{975,-2221},{7094,-2516},{9259,-4009},{7249,7809},{8473,2074},{4981,-6998},{9735,5737},{9772,5866},{8020,-6499},{8874,-6389},{3445,-9057},{4815,8167},{9847,1643},{4193,2322},{6780,2617},{9204,4107},{396,6298},{1591,6008},{2289,-4807},{3817,762},{7267,5150},{116,-6646},{887,-3760},{5572,-4741},{9741,4446},{5223,-462},{1742,38},{7705,1589},{1682,-1750},{263,4814},{867,9467},{8921,7616},{5765,-3135},{3624,4406},{2058,-2559},{1520,-675},{2591,-2012},{2679,-169},{4228,-1749},{5090,-6031},{2697,-9687},{9859,791},{352,3916},{8732,-1614},{2166,8995},{3200,9385},{4814,-1527},{7001,579},{5338,-3023},{1337,-2604},{4418,-7143},{3073,3362},{845,-7896},{3193,-8575},{6707,4635},{1746,-595},{4949,1605},{6548,-8347},{1873,5281},{39,-5961},{4276,-409},{9777,-909},{8064,3130},{6022,-245},{108,7360},{7151,4526},{6569,-3423},{4240,-2585},{8681,-2567},{5192,5389},{2069,-3061},{1146,3370},{4896,7694},{5023,6770},{2975,-8586},{7161,-6396},{1005,6938},{2695,-4579},{69,-4931},{5176,177},{2429,-1320},{1055,8999},{5257,-4704},{2766,-6062},{9081,-2042},{5679,-2498},{1249,6825},{7224,-3854},{872,2247},{2916,-6153},{3661,-9923},{7451,-8982},{7016,6498},{6440,-6563},{1568,-8384},{9966,-9651},{296,1021},{9348,-8095},{2669,8466},{2196,-8249},{2777,7875},{5605,4026},{1053,-7170},{172,-8075},{1429,-6912},{5772,-8557},{9518,-424},{2461,2886},{2426,-1099},{6323,-6006},{6870,-3711},{696,3518},{3662,6396},{5424,-3668},{4863,7620},{4435,7640},{1847,-3608},{8018,-7100},{9222,-5457},{4825,7004},{3983,-3050},{8447,-6499},{2878,-9092},{6387,5304},{6162,-938},{5651,3032},{5351,6347},{2902,-4634},{2743,8326},{8050,-6042},{2298,-1163},{7950,-9502},{5229,-4031},{3398,-9196},{512,-5424},{7808,847},{7878,6255},{4349,7108},{7163,736},{8764,9677},{6151,-5585},{2709,-2146},{7114,5612},{3220,-3790},{290,-8730},{168,8941},{107,-5529},{9439,-8311},{440,9189},{2493,7304},{117,6653},{8151,-5653},{2908,8852},{1455,-3577},{5941,-3428},{6101,-7908},{7339,5162},{9946,-5546},{7126,9519},{7016,3769},{789,7184},{2710,-2751},{1655,-1499},{5290,-1553},{4042,-2217},{2103,-9488},{788,-3393},{1211,3696},{1811,9019},{6471,-2248},{5591,8924},{6196,2930},{4087,6143},{3736,7565},{5662,-9248},{1334,2803},{4289,-9604},{6404,2296},{8897,-8306},{7096,-708},{5829,9199},{6156,-3383},{2158,-2633},{6665,-9678},{6386,3137},{8074,1977},{2061,4271},{4908,-7500},{6766,4996},{66,8780},{5749,1400},{7935,38},{1797,-5660},{2334,7046},{2386,9430},{2690,-1784},{4982,-1154},{1185,3492},{6214,-2149},{3814,8952},{7340,8241},{930,-4247},{8864,2190},{8254,5630},{7186,-5328},{762,9287},{6072,8697},{9325,-5779},{9389,1660},{7620,-8224},{7442,-9690},{9992,-7576},{5509,7529},{2269,8075},{5380,-3917},{7027,-7280},{4324,-5691},{8474,3188},{6499,3080},{5170,-9962},{7752,5932},{9325,176},{982,-1349},{4398,371},{6663,-1630},{2147,-9543},{5032,8491},{9234,541},{6021,1503},{8616,7753},{3938,-8004},{6826,8263},{6305,-8348},{7803,9157},{4732,-674},{9195,-1164},{5258,8520},{9012,2592},{3523,-238},{2964,6538},{8132,1463},{3348,-6835},{6307,2582},{58,-7672},{437,5027},{6433,4375},{7023,3259},{8990,-6672},{4911,3146},{2485,-4005},{2472,8032},{4831,-5918},{2905,196},{6675,6428},{9958,9639},{9319,4443},{7454,-7333},{3960,3761},{1601,-9630},{2441,2038},{5397,-1125},{6413,2420},{8486,1756},{2101,3398},{4902,938},{5745,-2626},{5323,-3071},{1456,8228},{7125,-1869},{1008,3435},{4122,6679},{4230,1577},{9346,8190},{1690,947},{4913,4132},{9337,310},{3007,-4249},{9083,-8507},{7507,-2464},{1243,-7591},{4826,-3011},{6135,-9851},{3918,7591},{8377,-2605},{5723,-4262},{830,-3803},{2417,-8587},{7774,8116},{5955,9465},{5415,868},{9949,-5247},{1179,2956},{6856,6614},{801,-9285},{4150,8397},{9476,8976},{1738,-4389},{9126,2008},{3202,3855},{9403,-4723},{9593,6585},{1475,-7989},{7998,-4399},{127,306},{1418,-4458},{1174,1367},{6647,-7647},{4323,3503},{8967,1477},{4218,9469},{6226,3694},{8446,-2036},{9305,3924},{9972,8860},{7779,5727},{4137,-6275},{8664,1964},{5736,-6985},{7566,-7785},{3321,8984},{4109,4495},{352,757},{3201,1027},{4260,-1480},{8856,4831},{7990,-4918},{8525,-7212},{3046,-5817},{6712,-630},{3043,-5509},{1449,-6468},{8216,-3534},{5497,304},{9481,3063},{8871,9154},{8399,2981},{1,8751},{90,-6798},{6131,-9298},{8075,-5013},{5533,6065},{70,-9589},{5205,9468},{946,1917},{5191,-6011},{2760,-7008},{3873,7329},{9458,9370},{7633,5291},{8785,2857},{797,3537},{2190,-9201},{2288,-7720},{353,4771},{9334,-1572},{9759,1220},{845,-3819},{7983,6050},{2001,-1071},{4319,-2808},{9270,7080},{6537,3143},{4409,2347},{8866,8394},{7639,4003},{7603,4788},{7540,-207},{5587,6181},{8425,5941},{952,-5888},{721,-2937},{5332,-8433},{3244,-6685},{3969,5246},{2244,8289},{8790,-8486},{1721,-4673},{1009,-3870},{7675,9875},{876,-8334},{231,-1520},{6454,7771},{4625,2042},{304,9403},{4335,-8743},{3515,-4944},{4672,8847},{2975,7917},{8514,6945},{3163,758},{1586,1953},{8624,-6693},{7281,9633},{5789,1308},{5861,-6983},{2974,-3908},{7849,-572},{215,-7525}}
                ));
    }

    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> keys = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < points.length; i++){
            for (int c = 0; c < points.length; c++) {

                int dis = getDistance(points[i], points[c]);

                sum += keys.getOrDefault(dis, 0) * 2;
                keys.put(dis,keys.getOrDefault(dis, 0) + 1);
            }
            keys.clear();
        }
        return sum;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }

}
