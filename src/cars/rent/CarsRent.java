/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars.rent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import koneksi.koneksi;

/**
 *
 * @author SHELBI
 */
public class CarsRent {
    
    
        
    static int[] id_Staff = new int[10];
    static String[] nama_Staff = new String[10];
    static String[] jk_Staff = new String[10];
    static int[] salary_Staff = new int[10];

    static int[] id_Mobil = new int[10];
    static String[] merk_Mobil = new String[10];
    static String[] nama_Mobil = new String[10];
    static long[] harga_Mobil = new long[10];

    static int[] id_Trans = new int[10];
    static int[] id_StaffTrans = new int[10];
    static int[] id_MobilTrans = new int[10];
    static String[] date_Start = new String[10];
    static String[] date_End = new String[10];
    static long[] total_Trans = new long[10];

    static int menu, salary, i, index, id, inttgl1, intbln1, intthn1, inttgl2, intbln2, intthn2;
    static boolean stat, stat1, stat2, statdate;
    static long diff, diffDays, total, dif, difDays;
    static String order, thn1, bln1, tgl1, back, thn2, bln2, tgl2, menu1, noid;
    static Date start, end, mul, sel;

    static Scanner input = new Scanner(System.in);
    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    // Mobil Section    
    public static void v_mobil() {
        do {
            System.out.println("");
            System.out.println(" \t\t CARS RECAP LIST ");
            System.out.println("=========================================================");
            System.out.println("|ID \t | Brand \t | Name \t | Price \t|");
            System.out.println("---------------------------------------------------------");

            for (i = 1; i < id_Mobil.length; i++) {
                if (id_Mobil[i] != 0) {
                    System.out.println("|" + id_Mobil[i] + "\t | " + merk_Mobil[i] + "\t | " + nama_Mobil[i] + "\t | " + harga_Mobil[i] + "\t|");
                }
            }

            System.out.println("=========================================================");

            System.out.println("");
            System.out.println("##### CAR MENU #####");
            System.out.println("----------------------");
            System.out.println(" 1. Entry Data ");
            System.out.println(" 2. Update Data ");
            System.out.println(" 3. Delete Data ");
            System.out.println(" 99. Back ");
            System.out.println("");
            do {
                System.out.print(" Choose : ");
                menu1 = input.next();
            } while (validNumber(menu1) == false);

            menu = Integer.parseInt(menu1);
            switch (menu) {
                case 1:
                    e_mobil();
                    break;
                case 2:
                    u_mobil();
                    break;
                case 3:
                    d_mobil();
                    break;
                case 99:
                    cls();
                    break;
                default:
                    System.err.println("Please Insert Correctly!");
            }
        } while (menu != 99);
    }

    public static void e_mobil() {
        index = 0;

        System.out.println("");
        System.out.println(" ENTRY CAR DATA ");
        System.out.println(" -------------- ");
        System.out.println("");

        if (index < id_Mobil.length) {
            for (i = 1; i < id_Mobil.length; i++) {
                if (id_Mobil[i] == 0) {
                    index = i;
                    break;
                }
            }

            System.out.println("Entry Car ID = " + (index));
            id_Mobil[index] = index;

            do {
                System.out.print("Entry Car Brand = ");
                merk_Mobil[index] = input.next();
            } while (validStr(merk_Mobil[index]) == false);

            do {
                System.out.print("Entry Car Name = ");
                nama_Mobil[index] = input.next();
            } while (validStr(nama_Mobil[index]) == false);

            do {
                System.out.print("Entry Rent Cost = ");
                harga_Mobil[index] = input.nextInt();
                if (harga_Mobil[index] < 100000 || harga_Mobil[index] > 500000) {
                    System.err.println("Range 100000 - 500000");
                }
            } while (harga_Mobil[index] < 100000 || harga_Mobil[index] > 500000);

            System.out.println("Data Inserted!");
            return;
        }
    }

    @SuppressWarnings("empty-statement")
    public static void u_mobil() {
        index = 1;

        System.out.println("");
        System.out.println(" UPDATE CAR DATA ");
        System.out.println(" --------------- ");

        do {
            stat = false;
            System.out.println("");

            do {
                do {
                    System.out.print("Entry Car ID = ");
                    noid = input.next();

                    if (noid.equals("0")) {
                        System.err.println("No ID has been matched!");
                    }
                } while (noid.equals("0"));
            } while (validNumber(noid) == false);

            id = Integer.parseInt(noid);
            for (i = 0; i < id_Mobil.length; i++) {
                if (id != id_Mobil[i]) {
                    stat = false;
                } else {
                    stat = true;
                    break;
                }
            }

            if (stat == false) {
                System.err.println("No ID has been matched!");
            } else {
                if (index - 1 < id_Mobil.length) {
                    for (i = 0; i < id_Mobil.length; i++) {
                        if (id_Mobil[i] == id) {
                            index = i;
                            break;
                        }
                    }

                    id_Mobil[index] = id;

                    do {
                        System.out.print("Entry Car Brand = ");
                        merk_Mobil[index] = input.next();
                    } while (validStr(merk_Mobil[index]) == false);

                    do {
                        System.out.print("Entry Car Name = ");
                        nama_Mobil[index] = input.next();
                    } while (validStr(nama_Mobil[index]) == false);

                    do {
                        System.out.print("Entry Rent Cost = ");
                        harga_Mobil[index] = input.nextInt();
                        if (harga_Mobil[index] < 100000 || harga_Mobil[index] > 500000) {
                            System.err.println("Range 100000 - 500000");
                        }
                    } while (harga_Mobil[index] < 100000 || harga_Mobil[index] > 500000);

                    System.out.println("Data Inserted!");
                } else {
                    System.out.println("Array Diluar Batas!");
                }
                return;
            }
        } while (stat == false);
    }

    public static void d_mobil() {
        index = 0;
        int noid;

        System.out.println("");
        System.out.println(" DELETE CAR DATA ");
        System.out.println(" --------------- ");

        do {
            stat = false;
            System.out.println("");
            do {
                System.out.print("Entry Car ID = ");
                noid = input.nextInt();

                if (noid == 0) {
                    System.err.println("No ID has been matched!");
                }
            } while (noid == 0);

            for (i = 0; i < id_Mobil.length; i++) {
                if (noid != id_Mobil[i]) {
                    stat = false;
                } else {
                    stat = true;
                    break;
                }
            }

            if (stat == false) {
                System.err.println("No ID has been matched!");
            } else {
                if (index < id_Mobil.length) {
                    for (i = 1; i < id_Mobil.length; i++) {
                        if (id_Mobil[i] == noid) {
                            index = i;
                            break;
                        }
                    }
                    id_Mobil[index] = 0;
                    merk_Mobil[index] = null;
                    nama_Mobil[index] = null;
                    harga_Mobil[index] = 0;

                    System.out.println(" Data Deleted!");
                } else {
                    System.out.println(" Array Diluar Batas!");
                }
                return;
            }
        } while (stat == false);
    }

    // Staff Section    
    public static void v_staff() {
        do {
            System.out.println("");
            System.out.println(" \t\t STAFF RECAP LIST ");
            System.out.println("===========================================");
            System.out.println("|ID \t | Name \t | L/P \t | Salary |");
            System.out.println("-------------------------------------------");
            for (i = 1; i < id_Staff.length; i++) {
                if (id_Staff[i] != 0) {
                    System.out.println("|" + id_Staff[i] + "\t | " + nama_Staff[i] + "\t | " + jk_Staff[i] + "\t | " + salary_Staff[i] + "\t  |");
                }
            }
            System.out.println("===========================================");

            System.out.println("");
            System.out.println("##### STAFF MENU #####");
            System.out.println("----------------------");
            System.out.println(" 1. Entry Data ");
            System.out.println(" 2. Update Data ");
            System.out.println(" 3. Delete Data ");
            System.out.println(" 88. Back ");
            System.out.println("");
            do {
                System.out.print(" Choose : ");
                menu1 = input.next();
            } while (validNumber(menu1) == false);

            menu = Integer.parseInt(menu1);

            switch (menu) {
                case 1:
                    e_staff();
                    break;
                case 2:
                    u_staff();
                    break;
                case 3:
                    d_staff();
                    break;
                case 88:
                    cls();
                    break;
                default:
                    System.err.println("Please Insert Correctly!");
            }
        } while (menu != 88);
    }

    public static void e_staff() {
        index = 0;

        System.out.println("");
        System.out.println(" ENTRY STAFF DATA ");
        System.out.println(" ---------------- ");

        if (index < id_Staff.length) {
            for (i = 1; i < id_Staff.length; i++) {
                if (id_Staff[i] == 0) {
                    index = i;
                    break;
                }
            }
            System.out.println("Entry Staff ID = " + (index + 1));
            id_Staff[index] = index + 1;

            do {
                System.out.print("Entry Staff Name = ");
                nama_Staff[index] = input.next();
            } while (validStr(nama_Staff[index]) == false);

            do {
                System.out.print("Entry Gender (L/P) = ");
                jk_Staff[index] = input.next();

                if (validJK(jk_Staff[index]) == false) {
                    System.err.println("Only L / P");
                }
            } while (validJK(jk_Staff[index]) == false);

            do {
                System.out.print("Entry Staff Salary = ");
                salary_Staff[index] = input.nextInt();
                if (salary_Staff[index] < 1000 || salary_Staff[index] > 5000) {
                    System.err.println("Range 1000 - 5000");
                }
            } while (salary_Staff[index] < 1000 || salary_Staff[index] > 5000);

            System.out.println("Data Inserted!");
        } else {
            System.out.println("Array Sudah Penuh!");
        }
        return;
    }

    public static void u_staff() {
        index = 0;
        String noid;

        System.out.println("");
        System.out.println(" UPDATE STAFF DATA ");
        System.out.println(" ----------------- ");

        do {
            stat = false;
            System.out.println("");

            do {
                do {
                    System.out.print("Entry Staff ID = ");
                    noid = input.next();

                    if (noid.equals("0")) {
                        System.err.println("No ID has been matched!");
                    }
                } while (noid.equals("0"));
            } while (validNumber(noid) == false);

            id = Integer.parseInt(noid);

            for (i = 1; i < id_Staff.length; i++) {
                if (id != id_Staff[i]) {
                    stat = false;
                } else {
                    stat = true;
                    break;
                }
            }
            if (stat == false) {
                System.err.println("No ID has been matched!");
            } else {
                if (index < id_Staff.length) {
                    for (i = 1; i < id_Staff.length; i++) {
                        if (id_Staff[i] == id) {
                            index = i;
                            break;
                        }
                    }

                    id_Staff[index] = id;

                    do {
                        System.out.print("Entry Staff Name = ");
                        nama_Staff[index] = input.next();
                    } while (validStr(nama_Staff[index]) == false);

                    do {
                        System.out.print("Entry Gender (L/P) = ");
                        jk_Staff[index] = input.next();

                        if (validJK(jk_Staff[index]) == false) {
                            System.err.println("Only L / P");
                        }
                    } while (validJK(jk_Staff[index]) == false);

                    do {
                        System.out.print("Entry Staff Salary = ");
                        salary_Staff[index] = input.nextInt();

                        if (salary_Staff[index] < 1000 || salary_Staff[index] > 5000) {
                            System.err.println("Range 1000 - 5000");
                        }
                    } while (salary_Staff[index] < 1000 || salary_Staff[index] > 5000);

                    System.out.println("Data Inserted!");
                } else {
                    System.out.println("Diluar Batas Array!");
                }
                return;
            }
        } while (stat == false);
    }

    public static void d_staff() {
        index = 0;
        int noid;

        System.out.println("");
        System.out.println(" DELETE STAFF DATA ");
        System.out.println(" ----------------- ");

        do {
            stat = false;
            System.out.println("");
            System.out.print("Entry Staff ID = ");
            noid = input.nextInt();

            for (i = 1; i < id_Staff.length; i++) {
                if (noid != id_Staff[i]) {
                    stat = false;
                } else {
                    stat = true;
                    break;
                }
            }
            if (stat == false) {
                System.err.println("No ID has been matched!");
            } else {
                if (index < id_Staff.length) {
                    for (i = 1; i < id_Staff.length; i++) {
                        if (id_Staff[i] == noid) {
                            index = i;
                            break;
                        }
                    }
                    id_Staff[index] = 0;
                    nama_Staff[index] = null;
                    jk_Staff[index] = null;
                    salary_Staff[index] = 0;

                    System.out.println("Data Deleted!");
                } else {
                    System.out.println("Array Sudah Penuh!");
                }
                return;
            }
        } while (stat == false);
    }

    // Trans Section
    public static void v_trans() {
        do {

            System.out.println("");
            System.out.println(" \t\t STAFF RECAP LIST ");
            System.out.println("===========================================");
            System.out.println("|ID \t | Name \t | L/P \t | Salary |");
            System.out.println("-------------------------------------------");
            for (i = 1; i < id_Staff.length; i++) {
                if (id_Staff[i] != 0) {
                    System.out.println("|" + id_Staff[i] + "\t | " + nama_Staff[i] + "\t | " + jk_Staff[i] + "\t | " + salary_Staff[i] + "\t  |");
                }
            }
            System.out.println("===========================================");

            System.out.println("");

            System.out.println("");
            System.out.println(" \t\t CARS RECAP LIST ");
            System.out.println("=========================================================");
            System.out.println("|ID \t | Brand \t | Name \t | Price \t|");
            System.out.println("---------------------------------------------------------");

            for (i = 1; i < id_Mobil.length; i++) {
                if (id_Mobil[i] != 0) {
                    System.out.println("|" + id_Mobil[i] + "\t | " + merk_Mobil[i] + "\t | " + nama_Mobil[i] + "\t | " + harga_Mobil[i] + "\t|");
                }
            }

            System.out.println("=========================================================");

            System.out.println("");
            System.out.println("");

            System.out.println("");
            System.out.println(" \t\t\t\t TRANSACTION DATA RECAP ");
            System.out.println("===============================================================================");
            System.out.println("| Trans ID | Staff ID | Car ID | Start Date | End Date | Total Cost |");
            System.out.println("-------------------------------------------------------------------------------");

            for (i = 0; i < id_Trans.length; i++) {
                if (id_Trans[i] != 0) {
                    System.out.println("|" + id_Trans[i] + "\t   | " + id_StaffTrans[i] + "\t      | " + id_MobilTrans[i] + "\t | " + date_Start[i] + "\t| " + date_End[i] + "\t| " + total_Trans[i] + "\t|");
                }
            }

            System.out.println("===============================================================================");

            System.out.println("");
            System.out.println("##### TRANSACTION MENU #####");
            System.out.println("--------------------------");
            System.out.println(" 1. Entry Data ");
            System.out.println(" 2. Update Data ");
            System.out.println(" 3. Loan Return ");
            System.out.println(" 77. Back ");
            System.out.println("");
            do {
                System.out.print(" Choose : ");
                menu1 = input.next();
            } while (validNumber(menu1) == false);

            menu = Integer.parseInt(menu1);

            switch (menu) {
                case 1:
                    e_trans();
                    break;
                case 2:
                    u_trans();
                    break;
                case 3:
                    d_trans();
                    break;
                case 77:
                    cls();
                    break;
                default:
                    System.err.println("Please Insert Correctly!");
            }
        } while (menu != 77);
    }

    public static void e_trans() {
        index = 0;
        stat1 = false;
        stat = false;
        statdate = false;

        System.out.println("");
        System.out.println(" ENTRY TRANSACTION DATA ");
        System.out.println(" ---------------------- ");

        if (index < id_Trans.length) {
            for (i = 1; i < id_Trans.length; i++) {
                if (id_Trans[i] == 0) {
                    index = i;
                    break;
                }
            }

            System.out.println("Entry Trans ID = " + (index));
            id_Trans[index] = index;

            do {
                do {
                    do {
                        System.out.print("Entry Staff ID = ");
                        noid = input.next();

                        if (noid.equals("0")) {
                            System.err.println("No ID has been matched!");
                        }
                    } while (noid.equals("0"));
                } while (validNumber(noid) == false);

                id = Integer.parseInt(noid);
                id_StaffTrans[index] = id;

                for (i = 0; i < id_Staff.length; i++) {
                    if (id != id_Staff[i]) {
                        stat = false;
                    } else {
                        stat = true;
                        break;
                    }
                }

                if (stat == false) {
                    System.err.println("No ID has been matched!");
                }
            } while (stat == false);

            do {
                do {
                    do {
                        System.out.print("Entry Car ID = ");
                        noid = input.next();

                        if (noid.equals("0")) {
                            System.err.println("No ID has been matched!");
                        }
                    } while (noid.equals("0"));
                } while (validNumber(noid) == false);

                id = Integer.parseInt(noid);
                id_MobilTrans[index] = id;

                for (i = 0; i < id_Mobil.length; i++) {
                    if (id != id_Mobil[i]) {
                        stat = false;
                    } else {
                        stat = true;
                        break;
                    }
                }

                if (stat == false) {
                    System.err.println("No ID has been matched!");
                }
            } while (stat == false);

            do {
                do {
                    date_Start[index] = null;
                    System.out.print("Entry Start Date (dd/mm/yyyy) = ");
                    order = input.next();

                    try {
                        Date now = new Date();
                        String nowStart = format.format(now);
                        Date nowDate = format.parse(nowStart);
                        Date orderDate = format.parse(order);

                        if (orderDate.getTime() < nowDate.getTime()) {
                            statdate = false;
                        } else {
                            statdate = true;
                        }

                    } catch (ParseException ex) {
//                        Logger.getLogger(CarsRent.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (order.length() != 10 || statdate == false) {
                        System.err.println("Invalid Date Format! Please Insert Again.");
                    }
                } while (order.length() != 10 || statdate == false);

                tgl1 = order.substring(0, 2);
                inttgl1 = Integer.parseInt(tgl1);
                bln1 = order.substring(3, 5);
                intbln1 = Integer.parseInt(bln1);
                thn1 = order.substring(6, 10);
                intthn1 = Integer.parseInt(thn1);

                if (kabisat(intthn1) == true) {
                    if ((intbln1 == 1 || intbln1 == 3 || intbln1 == 5 || intbln1 == 7 || intbln1 == 8 | intbln1 == 10 | intbln1 == 12) && inttgl1 <= 31) {
                        stat1 = true;
                    } else if ((intbln1 == 4 || intbln1 == 6 || intbln1 == 9 || intbln1 == 11) && inttgl1 <= 30) {
                        stat1 = true;
                    } else if (intbln1 == 2 && inttgl1 <= 29) {
                        stat1 = true;
                    } else {
                        stat1 = false;
                    }
                } else {
                    if ((intbln1 == 1 || intbln1 == 3 || intbln1 == 5 || intbln1 == 7 || intbln1 == 8 | intbln1 == 10 | intbln1 == 12) && inttgl1 <= 31) {
                        stat1 = true;
                    } else if ((intbln1 == 4 || intbln1 == 6 || intbln1 == 9 || intbln1 == 11) && inttgl1 <= 30) {
                        stat1 = true;
                    } else if (intbln1 == 2 && inttgl1 <= 28) {
                        stat1 = true;
                    } else {
                        stat1 = false;
                    }
                }

                if (checkAvailable(id_MobilTrans[index], order)) {
                    stat1 = true;
                } else {
                    System.err.println("Car is not Available !");
                    id_Trans[index] = 0;
                    return;
                }

                if (stat1 == true) {
                    date_Start[index] = order;
                } else {
                    System.err.println("Invalid Date | Please Insert Again!");
                }
            } while (stat1 == false);

            stat2 = false;
            do {
                do {
                    date_End[index] = null;
                    System.out.print("Entry End Date (dd/mm/yyyy) = ");
                    back = input.next();

                    if (back.length() != 10) {
                        System.err.println("Invalid Date Format! Please Insert Again.");
                    }
                } while (back.length() != 10);

                tgl2 = back.substring(0, 2);
                inttgl2 = Integer.parseInt(tgl2);
                bln2 = back.substring(3, 5);
                intbln2 = Integer.parseInt(bln2);
                thn2 = back.substring(6, 10);
                intthn2 = Integer.parseInt(thn2);

                if (duration(order, back) == true) {
                    if (kabisat(intthn2) == true) {
                        if ((intbln2 == 1 || intbln2 == 3 || intbln2 == 5 || intbln2 == 7 || intbln2 == 8 | intbln2 == 10 | intbln2 == 12) && inttgl2 <= 31) {
                            stat2 = true;
                        } else if ((intbln2 == 4 || intbln2 == 6 || intbln2 == 9 || intbln2 == 11) && inttgl2 <= 30) {
                            stat2 = true;
                        } else if (intbln2 == 2 && inttgl2 <= 29) {
                            stat2 = true;
                        } else {
                            stat2 = false;
                        }
                    } else {
                        if ((intbln2 == 1 || intbln2 == 3 || intbln2 == 5 || intbln2 == 7 || intbln2 == 8 | intbln2 == 10 | intbln2 == 12) && inttgl2 <= 31) {
                            stat2 = true;
                        } else if ((intbln2 == 4 || intbln2 == 6 || intbln2 == 9 || intbln2 == 11) && inttgl2 <= 30) {
                            stat2 = true;
                        } else if (intbln2 == 2 && inttgl2 <= 28) {
                            stat2 = true;
                        } else {
                            stat2 = false;
                        }
                    }
                } else {
                    stat2 = false;
                }

                if (stat2 == true) {
                    date_End[index] = back;
                } else {
                    System.err.println("Invalid Date | Please Insert Again!");
                }
            } while (stat2 == false);

            try {
                start = format.parse(order);
                end = format.parse(back);
                diff = end.getTime() - start.getTime();
                diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                diffDays = Math.abs(diffDays);
                total = diffDays * harga_Mobil[id_MobilTrans[index]];
                if (diffDays > 3) {
                    total_Trans[index] = (int) (total - total * 0.1);
                } else {
                    total_Trans[index] = total;
                }
            } catch (ParseException ex) {
//                Logger.getLogger(CarsRent.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Total Rent Cost = Rp. " + total_Trans[index]);

            System.out.println("");
            System.out.println("Data Inserted!");
        } else {
            System.out.println("Array Sudah Penuh!");
        }
        return;
    }

    public static void u_trans() {
        index = 0;
        stat1 = false;
        statdate = false;

        System.out.println("");
        System.out.println(" UPDATE TRANSACTION DATA ");
        System.out.println(" ----------------------- ");

        do {
            stat = false;
            System.out.println("");
            do {
                do {
                    System.out.print("Entry Transaction ID = ");
                    noid = input.next();
                    if (noid.equals("0")) {
                        System.err.println("No ID has been matched!");
                    }
                } while (noid.equals("0"));
            } while (validNumber(noid) == false);

            id = Integer.parseInt(noid);

            for (i = 0; i < id_Trans.length; i++) {
                if (id != id_Trans[i]) {
                    stat = false;
                } else {
                    stat = true;
                    break;
                }
            }

            if (stat == false) {
                System.err.println("No ID has been matched!");
            } else {
                if (index < id_Trans.length) {
                    for (i = 1; i < id_Trans.length; i++) {
                        if (id_Trans[i] == id) {
                            index = i;
                            break;
                        }
                    }

                    id_Trans[index] = id;
                    System.out.println("Entry Staff ID = " + id_StaffTrans[index]);
                    System.out.println("Entry Car ID = " + id_MobilTrans[index]);

                    do {
                        do {
                            date_Start[index] = null;
                            System.out.print("Start Date (dd/mm/yyyy) = ");
                            order = input.next();

                            if (order.length() != 10) {
                                System.err.println("Invalid Date Format! Please Insert Again.");
                            }
                        } while (order.length() != 10);

                        tgl1 = order.substring(0, 2);
                        inttgl1 = Integer.parseInt(tgl1);
                        bln1 = order.substring(3, 5);
                        intbln1 = Integer.parseInt(bln1);
                        thn1 = order.substring(6, 10);
                        intthn1 = Integer.parseInt(thn1);

                        if (kabisat(intthn1) == true) {
                            if ((intbln1 == 1 || intbln1 == 3 || intbln1 == 5 || intbln1 == 7 || intbln1 == 8 | intbln1 == 10 | intbln1 == 12) && inttgl1 <= 31) {
                                stat1 = true;
                            } else if ((intbln1 == 4 || intbln1 == 6 || intbln1 == 9 || intbln1 == 11) && inttgl1 <= 30) {
                                stat1 = true;
                            } else if (intbln1 == 2 && inttgl1 <= 29) {
                                stat1 = true;
                            } else {
                                stat1 = false;
                            }
                        } else {
                            if ((intbln1 == 1 || intbln1 == 3 || intbln1 == 5 || intbln1 == 7 || intbln1 == 8 | intbln1 == 10 | intbln1 == 12) && inttgl1 <= 31) {
                                stat1 = true;
                            } else if ((intbln1 == 4 || intbln1 == 6 || intbln1 == 9 || intbln1 == 11) && inttgl1 <= 30) {
                                stat1 = true;
                            } else if (intbln1 == 2 && inttgl1 <= 28) {
                                stat1 = true;
                            } else {
                                stat1 = false;
                            }
                        }

                        if (stat1 == true) {
                            date_Start[index] = order;
                        } else {
                            System.err.println("Invalid Date | Please Insert Again!");
                        }
                    } while (stat1 == false);

                    boolean stat2 = false;
                    do {
                        do {
                            date_End[index] = null;
                            System.out.print("End Date (dd/mm/yyyy) = ");
                            back = input.next();

                            if (back.length() != 10) {
                                System.err.println("Invalid Date Format! Please Insert Again.");
                            }
                        } while (back.length() != 10);

                        tgl2 = back.substring(0, 2);
                        inttgl2 = Integer.parseInt(tgl2);
                        bln2 = back.substring(3, 5);
                        intbln2 = Integer.parseInt(bln2);
                        thn2 = back.substring(6, 10);
                        intthn2 = Integer.parseInt(thn2);

                        if (duration(order, back) == true) {
                            if (kabisat(intthn2) == true) {
                                if ((intbln2 == 1 || intbln2 == 3 || intbln2 == 5 || intbln2 == 7 || intbln2 == 8 | intbln2 == 10 | intbln2 == 12) && inttgl2 <= 31) {
                                    stat2 = true;
                                } else if ((intbln2 == 4 || intbln2 == 6 || intbln2 == 9 || intbln2 == 11) && inttgl2 <= 30) {
                                    stat2 = true;
                                } else if (intbln2 == 2 && inttgl2 <= 29) {
                                    stat2 = true;
                                } else {
                                    stat2 = false;
                                }
                            } else {
                                if ((intbln2 == 1 || intbln2 == 3 || intbln2 == 5 || intbln2 == 7 || intbln2 == 8 | intbln2 == 10 | intbln2 == 12) && inttgl2 <= 31) {
                                    stat2 = true;
                                } else if ((intbln2 == 4 || intbln2 == 6 || intbln2 == 9 || intbln2 == 11) && inttgl2 <= 30) {
                                    stat2 = true;
                                } else if (intbln2 == 2 && inttgl2 <= 28) {
                                    stat2 = true;
                                } else {
                                    stat2 = false;
                                }
                            }
                        } else {
                            stat2 = false;
                        }

                        if (stat2 == true) {
                            date_End[index] = back;
                        } else {
                            System.err.println("Invalid Date | Please Insert Again!");
                        }
                    } while (stat2 == false);

                    try {
                        start = format.parse(order);
                        end = format.parse(back);
                        diff = start.getTime() - end.getTime();
                        diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                        diffDays = Math.abs(diffDays);
                        total = diffDays * harga_Mobil[id_MobilTrans[index]];
                        if (diffDays > 3) {
                            total_Trans[index] = (int) (total - total * 0.1);
                        } else {
                            total_Trans[index] = total;
                        }
                    } catch (ParseException ex) {
//                        Logger.getLogger(CarsRent.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println("Total Rent Cost = Rp. " + total_Trans[index]);

                    System.out.println("");
                    System.out.println("Data Inserted!");
                } else {
                    System.out.println("Diluar Batas Array!");
                }
                return;
            }
        } while (stat == false);
    }

    public static void d_trans() {
        index = 1;

        System.out.println("");
        System.out.println(" LOAN RETURN DATA ");
        System.out.println(" ----------------------- ");

        do {
            stat = false;
            System.out.println("");
            do {
                do {
                    System.out.print("Entry Transaction ID = ");
                    noid = input.next();
                    if (noid.equals("0")) {
                        System.err.println("No ID has been matched!");
                    }
                } while (noid.equals("0"));
            } while (validNumber(noid) == false);

            id = Integer.parseInt(noid);

            for (i = 0; i < id_Trans.length; i++) {
                if (id != id_Trans[i]) {
                    stat = false;
                } else {
                    stat = true;
                    break;
                }
            }

            if (stat == false) {
                System.err.println("No ID has been matched!");
            } else {
                try {
                    double fined;
                    if (date_End[i] != null) {
                        Date now = new Date();
                        String nowStart = format.format(now);
                        Date nowDate = format.parse(nowStart);
                        Date endDate = format.parse(date_End[i]);

                        if (endDate.equals(nowDate)) {
                            System.out.println(" On Time ! ");
                            System.out.println(" Bill : ");
                            System.out.println(" |> Order Payment : Rp." + total_Trans[i]);
                            System.out.println(" |> Fined : Rp.0");
                            System.out.println(" |> Total Purchase : Rp." + total_Trans[i]);

                            id_Trans[i] = 0;
                            id_Trans[i] = 0;
                            id_StaffTrans[i] = 0;
                            id_MobilTrans[i] = 0;
                            date_Start[i] = null;
                            date_End[i] = null;
                            total_Trans[i] = 0;
                        } else {
                            long denda;
                            denda = (nowDate.getTime() - endDate.getTime());
                            diffDays = TimeUnit.DAYS.convert(denda, TimeUnit.MILLISECONDS);
                            if (denda > 0) {
                                System.out.println(" Late, Fined! ");
                                System.out.println(" Bill : ");
                                System.out.println(" |> Order Payment : Rp." + total_Trans[i]);
                                fined = (diffDays * harga_Mobil[id_MobilTrans[index]] * 1.5);
                                System.out.println(" |> Fined : Rp." + fined);
                                System.out.println(" |> Total Purchase : Rp." + (total_Trans[i] + fined));

                                id_Trans[i] = 0;
                                id_Trans[i] = 0;
                                id_StaffTrans[i] = 0;
                                id_MobilTrans[i] = 0;
                                date_Start[i] = null;
                                date_End[i] = null;
                                total_Trans[i] = 0;
                            } else {
                                System.out.println(" This Transaction is not already finish. ");
                            }
                        }
                    }
                } catch (ParseException ex) {
                    //                    Logger.getLogger(CarsRent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (stat == false);
    }

    // Home Section
    public static void home() {
        do {
            System.out.println("=======================================");
            System.out.println("|------   SAISHOKU CARS RENT   -------|");
            System.out.println("=======================================");
            System.out.println("");

            System.out.println(" Start Menu : ");
            System.out.println(" 1. Car Data ");
            System.out.println(" 2. Staff Data ");
            System.out.println(" 3. Transaction ");
            System.out.println(" 0. Exit ");

            do {
                System.out.print(" Choose : ");
                menu1 = input.next();
            } while (validNumber(menu1) == false);

            menu = Integer.parseInt(menu1);
            switch (menu) {
                case 1:
                    v_mobil();
                    break;
                case 2:
                    v_staff();
                    break;
                case 3:
                    v_trans();
                    break;
                case 0:
                    System.out.println("");
                    System.out.println(" THANK YOU FOR USING THIS PROGRAM :) ");
                    break;
                default:
                    System.err.println("Please Insert Menu Correctly!");
                    break;
            }
            System.out.println("");
        } while (menu != 0);
    }

    public static void cls() {
        for (i = 1; i <= 10; i++) {
            System.out.println("");
        }
        System.out.println("\t ------- end -------");
        for (i = 1; i <= 10; i++) {
            System.out.println("");
        }
    }

    public static boolean kabisat(int intthn) {
        return intthn % 4 == 0 || intthn % 100 == 0 || intthn % 400 == 0;
    }

    public static boolean duration(String mulai, String selesai) {
        try {
            mul = format.parse(mulai);
            sel = format.parse(selesai);
            dif = sel.getTime() - mul.getTime();
            difDays = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
            difDays = Math.abs(difDays);

            if ((mul.getTime() > sel.getTime()) || difDays > 30 || mul.getTime() == sel.getTime()) {
                System.err.println("Date is not Accurate!");
                return false;
            } else {
                return true;
            }

        } catch (ParseException ex) {
//            Logger.getLogger(CarsRent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static boolean checkAvailable(int idMobil, String date) {
        for (i = 0; i < id_MobilTrans.length; i++) {
            if (id_MobilTrans[i] == idMobil) {
                try {
                    if (date_End[i] != null) {
                        Date endDate = format.parse(date_End[i]);
                        Date inputDate = format.parse(date);
                        if (endDate.getTime() >= inputDate.getTime()) {
                            return false;
                        }
                    }
                } catch (ParseException ex) {
//                    Logger.getLogger(CarsRent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }

    public static boolean validNumber(String numb) {
        if (!numb.matches("[0-9]*")) {
            System.err.println("Invalid! Must be Number only");
            return false;
        }
        return true;
    }

    public static boolean validJK(String jk) {
        return (jk.equals("L")) || (jk.equals("P"));
    }

    public static boolean validStr(String name) {
        if (!name.matches("[a-zA-Z]*")) {
            System.err.println("Invalid! Must be Letter only");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        id_Staff[0] = 0;
        id_Staff[1] = 1;
        id_Staff[2] = 2;
        id_Staff[3] = 3;
        id_Staff[4] = 4;
        id_Staff[5] = 5;

        nama_Staff[0] = null;
        nama_Staff[1] = "Shella";
        nama_Staff[2] = "Anisa";
        nama_Staff[3] = "Fadwa";
        nama_Staff[4] = "Nanda";
        nama_Staff[5] = "Mahendra";

        jk_Staff[0] = null;
        jk_Staff[1] = "P";
        jk_Staff[2] = "P";
        jk_Staff[3] = "P";
        jk_Staff[4] = "L";
        jk_Staff[5] = "L";

        salary_Staff[0] = 0;
        salary_Staff[1] = 2000;
        salary_Staff[2] = 3000;
        salary_Staff[3] = 2500;
        salary_Staff[4] = 3200;
        salary_Staff[5] = 1800;

        id_Mobil[0] = 0;
        id_Mobil[1] = 1;
        id_Mobil[2] = 2;
        id_Mobil[3] = 3;
        id_Mobil[4] = 4;
        id_Mobil[5] = 5;

        merk_Mobil[0] = null;
        merk_Mobil[1] = "Toyota";
        merk_Mobil[2] = "Suzuki";
        merk_Mobil[3] = "Kijang";
        merk_Mobil[4] = "Daihatsu";
        merk_Mobil[5] = "Honda";

        nama_Mobil[0] = null;
        nama_Mobil[1] = "Avanza";
        nama_Mobil[2] = "Expander";
        nama_Mobil[3] = "Innova";
        nama_Mobil[4] = "Terios";
        nama_Mobil[5] = "Civic";

        harga_Mobil[0] = 0;
        harga_Mobil[1] = 170000;
        harga_Mobil[2] = 200000;
        harga_Mobil[3] = 180000;
        harga_Mobil[4] = 220000;
        harga_Mobil[5] = 250000;

        home();
    }
}
