package com.javarush.test.level17.lesson10.bonus02;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index)
на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException, ParseException
    {
        //start here - начни тут
        String command = args[0];
        String inputString = "";
        for (int i = 1; i<args.length; i++) {
            inputString += args[i] + " ";
        }
        String[] inputParam = inputString.split(" ");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (command) {
            case "-c":{
                String name="";
                int count = 0;
                for (int i = 0; i<inputParam.length; i++) {
                    if (!inputParam[i].equals("м")&&!inputParam[i].equals("ж")) {name+=inputParam[i]+" "; count++;} else break; }
                name = name.substring(0, name.length()-1);

                String sex = inputParam[count];
                Date birthdate = simpleDateFormat.parse(inputParam[count+1]);
                if (sex.equals("м")) {
                    allPeople.add(Person.createMale(name, birthdate));
                }
                else if (sex.equals("ж")) {
                    allPeople.add(Person.createFemale(name, birthdate));
                }
            }
            System.out.println(allPeople.size()-1);
            break;

            case "-u": { //-u id name sex bd
                int id = Integer.parseInt(inputParam[0]);
                String name="";
                int count = 1;
                for (int i = 1; i<inputParam.length; i++) {
                    if (!inputParam[i].equals("м")&&!inputParam[i].equals("ж")) {name+=inputParam[i]+" "; count++;} else break; }
                name = name.substring(0, name.length()-1);

                String sex = inputParam[count];
                Date birthdate = simpleDateFormat.parse(inputParam[count+1]);

                if (sex.equals("м")) {
                    Person p = allPeople.get(id);
                    p.setName(name);
                    p.setSex(Sex.MALE);
                    p.setBirthDay(birthdate);
                }
                else if (sex.equals("ж")) {
                    Person p = allPeople.get(id);
                    p.setName(name);
                    p.setSex(Sex.FEMALE);
                    p.setBirthDay(birthdate);
                }
            } break;
            case "-d": {
                Person p = allPeople.get(Integer.parseInt(inputParam[0]));
                p.setBirthDay(null);
                p.setName(null);
                p.setSex(null);
            } break;
            case "-i": { //id: name sex (м/ж) bd (формат 15-Apr-1990)
                int id = Integer.parseInt(inputParam[0]);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Person p = allPeople.get(id);
                String sex;
                if (p.getSex()==Sex.MALE) {
                    sex = "м";
                }
                else sex = "ж";
                System.out.println(p.getName() + " " + sex + " " + sdf.format(p.getBirthDay()));

            } break;
        }

    }
}

//https://gist.github.com/Konstantin-Kuznetsov/c6724ab266334e4d2508231d5a9b0dd1