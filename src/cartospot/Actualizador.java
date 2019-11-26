/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartospot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LuisOrt
 */
public class Actualizador extends javax.swing.JFrame {

    /**
     * Creates new form Actualizador
     */
    int d1[] = {108, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 152, 153, 154, 155, 156, 162, 163, 164, 165, 166, 167, 168, 169, 172, 173, 197, 198, 303, 357, 361, 370, 371, 372};
    int d2[] = {109, 111, 112, 113, 114, 115, 116, 117, 143, 144, 145, 146, 147, 148, 149, 150, 151, 174, 175, 176, 177, 178, 179, 180, 181, 304, 354, 355, 356, 362, 363, 364, 365, 366, 367, 368, 369, 377, 378, 379, 380, 381, 382, 383, 419, 1394, 1395, 1396, 1397, 1398, 1399, 1400, 1401, 1402, 1403, 1404, 1405, 1406, 1407, 1408, 1409, 1410, 1411, 1412, 1413, 1414, 1415};
    int d3[] = {182, 183, 184, 218, 219, 220, 221, 222, 250, 251, 252, 253, 254, 255, 276, 277, 278, 279, 280, 281, 282, 283, 296, 297, 298, 299, 300, 301, 302, 384, 385, 391, 392, 393, 394, 395, 396, 397, 402, 403, 404, 405, 410, 411, 412, 413, 414, 415};
    int d4[] = {199, 200, 201, 204, 236, 237, 238, 271, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 358, 359, 360, 373, 374, 375, 376, 386, 387, 388, 389, 390, 398, 399, 400, 401, 406, 407, 408, 409, 416, 417, 418};
    int d5[] = {157, 158, 159, 160, 161, 170, 171, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 202, 203, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 272, 273, 274, 275, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316};
    int d6[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1098, 1099, 1100, 1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1114, 1115, 1116, 1117, 1118, 1120, 1121, 1122, 1123, 1125, 1126, 1127, 1128, 1130, 1131, 1132, 1133, 1134, 1135, 1136, 1137, 1138, 1139};
    int d7[] = {42, 43, 44, 45, 46, 47, 48, 50, 51, 52, 53, 54, 55, 56, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 1200, 1201, 1202, 1203, 1204, 1205, 1206, 1207, 1208, 1209, 1210, 1211, 1212, 1213, 1214, 1215, 1217, 1218, 1219, 1220, 1221, 1222, 1223, 1224, 1225, 1226, 1227, 1228, 1229, 1230, 1231, 1232, 1233, 1234, 1235, 1236, 1237, 1238, 1240, 1241, 1242, 1243, 1244, 1245, 1246, 1247, 1248, 1249, 1250, 1251, 1252, 1253, 1254, 1255, 1256, 1257, 1258, 1259, 1260, 1261, 1262, 1274, 1275, 1276, 1277, 1278, 1279, 1280, 1281, 1282, 1283, 1284, 1285, 1286, 1287, 1288, 1289, 1290, 1291, 1292, 1293, 1294, 1295, 1296, 1297, 1298, 1299, 1300, 1301, 1302, 1304, 1305, 1306, 1307, 1308, 1309, 1310, 1311, 1312, 1313, 1314, 1315, 1316, 1317, 1318, 1319, 1320, 1321, 1322, 1323, 1324, 1325, 1326, 1327, 1328, 1329, 1330, 1331, 1332, 1360, 1361, 1362, 1363, 1364, 1365, 1367, 1368, 1369, 1370, 1371, 1372, 1373, 1391};
    int d8[] = {57, 58, 59, 60, 61, 62, 63, 64, 65, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 649, 651, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 921, 922, 923, 924, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1156, 1157, 1158, 1159, 1160, 1161, 1162, 1163, 1164, 1165, 1166, 1167, 1168, 1169, 1170, 1171, 1172, 1173, 1174, 1175, 1176, 1177,
         1178};
    int d9[] = {664, 665, 666, 667, 668, 669, 670, 671, 728, 729, 730, 736, 737, 738, 739, 740, 741, 742, 743, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 778, 780, 781, 782, 783, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 1179, 1180, 1181, 1182, 1183, 1184, 1185, 1186, 1187, 1188, 1189, 1190, 1333, 1334, 1335, 1336, 1337, 1338, 1339, 1340, 1341, 1342, 1344, 1345, 1346, 1347, 1348, 1349, 1350, 1351, 1352, 1353, 1354, 1355, 1356, 1357, 1358, 1359, 1392, 1393};
    int d10[] = {446, 450, 451, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 600, 601, 602, 603, 604, 605, 1416, 1417, 1418, 1419, 1420, 1421, 1422, 1423, 1424, 1425, 1426, 1427, 1428, 1429, 1430, 1431, 1432, 1433, 1434, 1435, 1438};
    int d11[] = {436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 606, 609, 610, 611};
    int d12[] = {448, 449, 485, 486, 487, 488, 489, 490, 491, 492, 493, 511, 512, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 607, 608, 1436, 1437, 1439, 1440, 1441, 1442, 1443, 1444, 1445, 1446, 1447};
    int d13[] = {689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 731, 732, 733, 734, 735, 744, 745, 746, 747, 760, 761, 762, 763};
    int d14[] = {66, 67, 68, 69, 70, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 99, 100, 101, 102, 103, 104, 105, 106, 107, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 977, 978, 979, 980, 981, 982, 983, 985, 986, 987, 988, 989, 990, 991, 1140, 1141, 1142, 1143, 1144, 1145, 1146, 1147, 1148, 1149, 1150, 1151, 1152, 1153, 1154, 1155, 1191, 1192, 1193, 1194, 1195, 1196, 1197, 1198, 1199};
    int d15[] = {796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014, 1263, 1264, 1265, 1266, 1267, 1268, 1269, 1270, 1271, 1272, 1273, 1374, 1375, 1376, 1377, 1378, 1379, 1380, 1381, 1382, 1383, 1384, 1385, 1386, 1387, 1388, 1389, 1390};
    
    ArrayList DttsLoc= new ArrayList();  
    public Actualizador() {
        initComponents();
        this.setLocationRelativeTo(null);
        DttsLoc.add(d1);
        DttsLoc.add(d2);
        DttsLoc.add(d3);
        DttsLoc.add(d4);
        DttsLoc.add(d5);
        DttsLoc.add(d6);
        DttsLoc.add(d7);
        DttsLoc.add(d8);
        DttsLoc.add(d9);
        DttsLoc.add(d10);
        DttsLoc.add(d11);
        DttsLoc.add(d12);
        DttsLoc.add(d13);
        DttsLoc.add(d14);
        DttsLoc.add(d15);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Seleccionar AC-10r");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Abrir xlsx");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cerrar");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(jButton2))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    File inputs[];
    File output;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser choser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos de Excel", "xlsx", "xls");
        choser.addChoosableFileFilter(filter);
        choser.setMultiSelectionEnabled(true);
        choser.setAcceptAllFileFilterUsed(false);
        int returnVal = choser.showOpenDialog(jPanel1);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            inputs = choser.getSelectedFiles();
            //output=new File(getClass().getResource("/Seccion/Data").getFile());
            output = new File(Paths.get("").toAbsolutePath().toString() + "/Data");
            Thread analiza = new analizaXlsx();
            analiza.start();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    int DttoLoc = 0;

    
    class buscador extends Thread {
        
        public buscador(int[] dtto, int s) {
            for (int i = 0; i < dtto.length; i++) {
                if (dtto[i] == s) {
                    break;
                }
            }
        }
    }

    String tex="";

    class analizaXlsx extends Thread {

        public void run() {
            for (int i = 0; i < inputs.length; i++) {
                int cont=0;
                try {
                    if (!output.exists()) {
                        jTextArea1.setText("Creando archivo Data");
                        output.createNewFile();
                    } else {
                        jTextArea1.append(tex+"\nAgregando al archivo...");
                    }
                    tex+=inputs[i].getName()+"\n";
                
                    FileOutputStream os = new FileOutputStream(output, true);
                    PrintStream printStream = new PrintStream(os);
                    
                    XSSFWorkbook wBook = new XSSFWorkbook(inputs[i]);
                    XSSFSheet sheet = wBook.getSheetAt(0);
                    Row row;
                    Cell cell;
                    Iterator<Row> rowIterator = sheet.iterator();
                    cont = 0;
                    rowIterator.next();
                    rowIterator.next();
                    while (rowIterator.hasNext()) {
                        row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        int f = 0;
                        String[] e = new String[9];
                        while (cellIterator.hasNext()) {
                            cell = cellIterator.next();
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_BLANK:
                                    e[f] = "" + "|";
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    Double n = cell.getNumericCellValue();
                                    e[f] = n.intValue() + "|";
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    e[f] = cell.getStringCellValue() + "|";
                                    break;
                            }
                            f++;
                        }
                        //e[]=0.-entidad, 1.-Durango, 2.-Dtto Fed, 3.-id Mun, 4.-nom Mun, 5.-id Loca, 6.-nom Loc, 7.-Tipo, 8.-Secion
                        //Data=1.-sec, 2.-dtto loc 3.- Dtto fed, 4.-id mun, 5.-Nom Mun, 6.-id Loc 7.-Nom Loc,8.-Tipo de loc

                        //data.append(e[8]+getDttoLoc(e[8])+e[1]+e[3]+e[4]+e[5]+e[6]+e[7]);
                        printStream.print(e[8] + getDttoLoc(e[8]) + e[2] + e[3] + e[4] + e[5] + e[6] + e[7] + "\n");
                        //data.append(e[8]+getDttoLoc(e[8])+e[2]+e[3]+e[4]+e[5]+e[6]+e[7]+"\n"); 
                        cont++;
                        jTextArea1.setText(tex+"\n"+cont);
                    }
                    printStream.close();
                } catch (IOException | InvalidFormatException x) {
                    jTextArea1.setText(tex+"\ncargando...");
                    tex+=" "+cont+" Registros\n";
                }
                
            }
            jTextArea1.setText(tex+"\nData Generado con exito\n");
        }
    }

    
    
    private String getDttoLoc(String sec) {
        int seci = Integer.parseInt(sec.substring(0, sec.length() - 1));
        for(int i=0; i<DttsLoc.size(); i++){
            int dtto[]=(int[]) DttsLoc.get(i);
            for (int j=0; j< dtto.length; j++){
                if(seci==dtto[j]){
                    return i+1+"|";
                }
            }
        }
        return "---";
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        INE.jButton2.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
