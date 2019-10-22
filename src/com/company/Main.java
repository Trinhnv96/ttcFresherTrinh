package com.company;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<Bill> listBill = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        HashMap<String, List<Bill>> hashMap = new HashMap<>();
        int selectExercise;
        String str = null, characters = null;
        int positionN = 0;
        String time = "2019-10-22 14:08:40";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nSelect exercise :");
            System.out.println("\nI:Exercise List,set,hashMap " +
                    "\n1.Exercise 1 \n2.Exercise 2 \n3.Exercise 3 \n4.Exercise 4 " +
                    "\n5.Exercise 5 \n6.Exercise 6 \n7.Exercise 7 " +
                    "\n8.Exercise 8 " +
                    "\nII:Exercise string \n9.Exercise 9" +
                    "\n10.Exercise 10 \n11.Exercise 11 \n12.Exercise 12" +
                    "\n13.Exercise 13 " +
                    "\nIII.Exercise Date,SimpleDateFormat \n14.Exercise 14 \n15.Exercise 15 " +
                    "\n16.Exercise 16 \n17.Exercise 17 \n18.Exercise 18 \n19.Exercise 19 \n20.Exercise 20" +
                    "\n0.Stop select");
            selectExercise = sc.nextInt();

            if (selectExercise == 1) {
                int stn = 0, sum = 0;
                main.input(stn, sum);
            }

            if (selectExercise == 2) {
                int n = 0;
                main.inputList(n);
            }

            if (selectExercise == 3) {
                main.addData(listBill);
                main.showListBill(listBill);
                main.sortBill(listBill);
            }

            if (selectExercise == 4) {
                main.addData(listBill);
                main.distinctDate(listBill);
            }

            if (selectExercise == 5) {
                main.addData(listBill);
                main.showListBillMillion(listBill);
            }

            if (selectExercise == 6) {
                main.addData(listBill);
                hashMap = main.inputListBillSameDay(listBill);
                System.out.print(hashMap);
            }

            if (selectExercise == 7) {
            }

            if (selectExercise == 8) {

            }

            if (selectExercise == 9) {
                str = main.inputString();
                characters = main.inputCharacters();
                positionN = main.inputPositionN();
                main.countCharacters(str, characters, positionN);
            }

            if (selectExercise == 10) {
                str = main.inputString();
                main.findCharacter(str);
                main.distinctString(str);
            }

            if (selectExercise == 11) {
                main.addListString(listString);
                System.out.print(main.concatenationString(listString));
            }

            if (selectExercise == 12) {
                main.splitString(listString);
            }

            if (selectExercise == 13) {
                main.replaceString("I am fresher", "fresher", "senior");
            }

            if (selectExercise == 14) {
                main.convertJavaDate(time);
                System.out.print(time + "\nTime after transfer :" + main.convertJavaDate(time));
            }

            if (selectExercise == 15) {
                main.getFistDayOfMonth(time);
                main.getLastDayOfMonth(time);
                main.getFirstDayOfWeek(time);
                main.getTheNext100days(time);
            }

            if (selectExercise == 16) {
                main.compareDate();
            }

            if (selectExercise == 17) {
                main.countTimeApart();
            }

            if (selectExercise == 18) {
                main.converTimeStamp();
            }

            if (selectExercise == 19) {
                main.convertToTimestampRound();
            }

            if (selectExercise == 20) {
                main.convertNewString();
            }

            if (selectExercise == 0) System.exit(selectExercise);
        }
    }

    //Bài 1
    public void input(int stn, int sum) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the natural number n :");
        stn = scanner.nextInt();
        System.out.printf("\nThe sequence of natural numbers is:");
        for (int i = 0; i <= stn; i++) {
            System.out.print(i + " ");
        }
        for (int i = 0; i <= stn; i++) {
            sum += i;
        }
        System.out.print("\nThe sum of n consecutive natural numbers:" + sum);
    }

    //Bài 2
    public void inputList(int n) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the number of elements in the array :");
            n = scanner.nextInt();
        } while (n < 0);
        List<Integer> listInt = new ArrayList<>();
        System.out.print("\nEnter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter the elements for the array " + i + ":");
            listInt.add(scanner.nextInt());
        }

        System.out.print("\nThe array just entered is :");
        for (int i = 0; i < listInt.size(); i++) {
            System.out.print(listInt.get(i) + " ");
        }
        System.out.print("\nArray after sort is:");
        Collections.sort(listInt);
        System.out.print(listInt);
    }

    //Bài 3
    public void addData(List<Bill> listBill) {
        listBill.clear();
        listBill.add(new Bill(303, "HD1", 3600000, "2019-08-12"));
        listBill.add(new Bill(112, "HD2", 5000, "2019-09-21"));
        listBill.add(new Bill(105, "HD3", 45000, "2019-01-21"));
        listBill.add(new Bill(132, "HD4", 5000000, "2019-09-21"));
        listBill.add(new Bill(125, "HD5", 45000, "2019-01-21"));
        listBill.add(new Bill(122, "HD6", 1000000, "2019-01-21"));
    }

    public void showListBill(List<Bill> listBill) {
        System.out.print("Original bill list :");
        for (int i = 0; i < listBill.size(); i++) {
            System.out.print("\n" + "Bill " + i + ":");
            System.out.print("\nID: " + listBill.get(i).id + "\nName: " + listBill.get(i).name +
                    "\nMoney: " + listBill.get(i).money + "\nDate: " + listBill.get(i).date);
            System.out.print("\n=======================");
        }
    }

    public void sortBill(List<Bill> listBill) {
        long temp = 0;
        for (int i = 0; i < listBill.size(); i++) {
            for (int j = i + 1; j < listBill.size(); j++) {
                if (listBill.get(i).money > listBill.get(j).money) {
                    temp = listBill.get(i).money;
                    listBill.get(i).money = listBill.get(j).money;
                    listBill.get(j).money = temp;
                }
            }
        }

        System.out.print("\nInvoice after arrangement is :");
        for (int i = 0; i < listBill.size(); i++) {
            System.out.print("\n" + "Bill " + i + ":");
            System.out.print("\nID: " + listBill.get(i).id + "\nName: " + listBill.get(i).name +
                    "\nMoney: " + listBill.get(i).money + "\nDate: " + listBill.get(i).date);
            System.out.print("\n=======================");
        }
    }

    //Bài 4
    public void distinctDate(List<Bill> listBill) {
        System.out.print("\nList after listing duplicates");
        List<String> listDate = new ArrayList<>();
        for (int i = 0; i < listBill.size(); i++) {
            listDate.add(listBill.get(i).date);
        }
        List<String> listDistinctDate = listDate
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listDistinctDate);
    }

    //Bài 5
    public void showListBillMillion(List<Bill> listBill) {
        for (int i = 0; i < listBill.size(); i++) {
            if (listBill.get(i).money > 1000000) {
                System.out.print("\nID: " + listBill.get(i).id + "\nName: " + listBill.get(i).name +
                        "\nMoney: " + listBill.get(i).money + "\nDate: " + listBill.get(i).date);
                System.out.print("\n=======================");
            }
        }
    }

    //Bài 6
    public HashMap<String, List<Bill>> inputListBillSameDay(List<Bill> billList) {
        HashMap<String, List<Bill>> listHashMap = new HashMap<>();
        for (Bill bill : billList) {
            List<Bill> listBillSameDays = new ArrayList<>();
            listBillSameDays.add(bill);
            if (listHashMap.containsKey(bill.getDate())) {
                listBillSameDays.addAll(listHashMap.get(bill.getDate()));
            }
            listHashMap.put(bill.getDate(), listBillSameDays);
        }

        return listHashMap;
    }

    //Bài 7
    //Bài 8
    //II:Bài tập về String
    //Bài1
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the string :");
        String str = scanner.nextLine();
        return str;
    }

    public String inputCharacters() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the characters to search :");
        String characters = scanner.nextLine();
        return characters;
    }

    public int inputPositionN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter position n :");
        int n = scanner.nextInt();
        return n;
    }

    private void countCharacters(String inputString, String character, int positionN) {
        int positionFirst = -1;
        int positionLast = 0;
        int countAppear = 0;
        int positionN2 = 0;
        for (int i = 0; i <= inputString.length() - character.length(); i++) {
            if (character.equals(inputString.substring(i, i + character.length()))) {
                countAppear++;
                if (positionFirst == -1) {
                    positionFirst = i;
                }

                if (i > positionLast) {
                    positionLast = i;
                }
                positionN2 = inputString.indexOf(character, inputString.indexOf(character) + positionN);
            }
        }

        if (countAppear > 0) {
            System.out.print("\nThe number of occurrences :" + countAppear);
            System.out.print("\nFirst place :" + positionFirst);
            System.out.print("\nThe last position:" + positionLast);
            System.out.print("\nThe n position:" + positionN2);
        }
    }

    //Bài 2
    private void findCharacter(String str) {
        Map<Character, Integer> maps = new HashMap<>();
        for (char ch : str.toCharArray()) {
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
        }
        int maxValue = Collections.max(maps.values());
        for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println("Most frequent character: " + entry.getKey());
            }
        }
    }

    private void distinctString(String str) {
        String sub;
        List<String> listSub = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j <= str.length() - i; j++) {
                sub = str.substring(i, i + j);
                listSub.add(sub);
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(listSub);
        listSub.clear();
        listSub.addAll(hs);
        for (String str2 : listSub) {
            System.out.print("\nAll Elements are Distinct: " + str2);
        }
        System.out.print("\nThe number of occurrences of those substrings:" + listSub.size());
    }

    //Bài 3
    private void addListString(List<String> listString) {
        listString.clear();
        listString.add("Xuân");
        listString.add("Hạ");
        listString.add("Thu");
        listString.add("Đông");
    }

    private String concatenationString(List<String> stringList) {
        String text = "";
        for (int i = 0; i < stringList.size(); i++) {
            text += stringList.get(i);
            if (i < stringList.size() - 1) {
                text += ",";
            }

        }
        return text;
    }

    //Bài 4
    private void splitString(List<String> listString) {
        addListString(listString);
        System.out.print("\nThe original string :" + concatenationString(listString));
        String str = concatenationString(listString);
        String[] splitString = str.split(",");
        List<String> listSpitString = new ArrayList<>();
        for (int i = 0; i < splitString.length; i++) {
            listSpitString.add(splitString[i]);
        }
        for (int i = 0; i < listString.size(); i++) {
            System.out.print("\n" + listSpitString.get(i));
        }
    }

    //Bài 5
    private void replaceString(String raw, String from, String to) {
        String result = raw;
        for (int i = 0; i <= result.length() - from.length(); i++) {
            if (from.equals(result.substring(i, i + from.length()))) {
                result = result.substring(0, i) + to + result.substring(i + from.length());
            }
        }
        System.out.print(result);
    }

    //III.Bài tập về date và SimpleDateFormat
    //Bài 1
    private Date convertJavaDate(String strTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //Bài 2
    private void getFistDayOfMonth(String strTime) {
        Date date = convertJavaDate(strTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String fistDayOfMonth = simpleDateFormat.format(date);
        System.out.print("\nThe first day of the month :" + fistDayOfMonth);

    }

    private void getLastDayOfMonth(String strTime) {
        Date date = convertJavaDate(strTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String lastDayOfMonth = simpleDateFormat.format(date);
        System.out.print("\nThe last day of the month :" + lastDayOfMonth);
    }

    private void getFirstDayOfWeek(String strTime) {
        Date date = convertJavaDate(strTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String firstDayOfWeek = simpleDateFormat.format(date);
        System.out.print("\nThe first day of the week :" + firstDayOfWeek);
    }

    private void getTheNext100days(String strTime) {
        Date date = convertJavaDate(strTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 100);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        date = calendar.getTime();
        String next100days = simpleDateFormat.format(date);
        System.out.print("\nThe next 100 days :" + next100days);
    }

    //Bài 3
    private Date convertJavaDate2(String strTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private void compareDate() {
        String strTime = "1996-05-17";
        String strTime2 = "2010-08-30";
        Date date = convertJavaDate2(strTime);
        Date date2 = convertJavaDate2(strTime2);
        if (date.compareTo(date2) < 0)
            System.out.println("Date is lesser than date2");
        else if (date.compareTo(date2) > 0)
            System.out.println("Date is greater than date2");
        else
            System.out.println("Both Dates are equal");
    }

    //Bài 4
    private void countTimeApart() {
        String strTime = "1996-05-17";
        String strTime2 = "1999-06-17";
        Date date = convertJavaDate2(strTime);
        Date date2 = convertJavaDate2(strTime2);
        long difference_ms = Math.abs(date.getTime() - date2.getTime());
        int days = Math.round(difference_ms / (1000 * 60 * 60 * 24));

        long monthsBetween = ChronoUnit.MONTHS.between(
                LocalDate.parse(strTime).withDayOfMonth(1),
                LocalDate.parse(strTime2).withDayOfMonth(1));

        long yearsBetween = ChronoUnit.YEARS.between(
                LocalDate.parse(strTime).withDayOfMonth(1),
                LocalDate.parse(strTime2).withDayOfMonth(1));

        System.out.print("\nDay between  " + strTime + " and " + strTime2 + ": " + days);
        System.out.println("\nMonth between " + strTime + " and " + strTime2 + ": " + monthsBetween);
        System.out.println("\nYear between " + strTime + " and " + strTime2 + ": " + yearsBetween);
    }


    //Bài 5
    private void converTimeStamp() {
        String strTimeDate = "2019/10/22 15:34:44";
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = dataFormat.parse(strTimeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("\nConvert string to timestamp : " + timestamp.getTime());
        //convert timestamp về lại ban đầu(String)
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String string = dateFormat.format(timestamp);
        System.out.println("\nConvert timestamp to string " + string);
    }

    //Bài 6
    private void convertToTimestampRound() {
        String strTime = "2019/10/22 15:34:44";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(strTime, dtf);

        int minutes = localDateTime.getMinute();
        if (minutes >= 30)
        {
            localDateTime = localDateTime.plusHours(1);
        }
        localDateTime = localDateTime.truncatedTo(ChronoUnit.HOURS);
        String roundedTime = dtf.format(localDateTime);
        Date date=convertJavaDate3(roundedTime);
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("\ntimestamp when rounded : " + timestamp.getTime());



    }



    //Bài 7
    private Date convertJavaDate3(String strTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private void convertNewString() {
        String strTime = "2019/10/22 15:34:44";
        Date date = convertJavaDate3(strTime);
        SimpleDateFormat formatOne = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatTwo = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
        System.out.print("\nFormat one :" + formatOne.format(date));
        System.out.print("\nFormat two :" + formatTwo.format(date));
    }
}
