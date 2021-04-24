package com.cydzs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * private List<Person> list 容器
 * addLogic() 用户添加记录业务逻辑控制
 * searchLogic() 用户查询记录业务逻辑控制
 * modifyLogic() 修改记录业务逻辑控制
 * deleteLogic() 删除记录业务逻辑控制
 * orderLogic() 排序记录业务逻辑控制
 * addOperation () 添加新记录信息
 * showAll() 查询全部记录
 * searchByName() 按姓名查询记录
 * searchByAge() 按年龄查询记录
 * searchBySex() 按性别查询记录
 * searchByTelNum() 按电话号码查询记录
 * searchByAdd() 按地址查询记录
 * modifyOperation() 修改指定记录
 * deleteOperation() 删除指定记录
 * deleteAllOperation() 删除全部记录
 * orderName() 按用户姓名排序记录
 * orderAge() 按用户年龄排序记录
 * orderSex() 按用户性别排序记录
 */
public class Operate {
    private List<Person> list;
    public  Operate() {
        this.list = new ArrayList<>();
        this.list.add(readPerson());

    }
    //用户添加记录业务逻辑控制
    public void addLogic(){
        Menu menu =new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.addMenu();
            int item =regex.menuItemValidate(1,3);

            switch (item){
                case 1: this.addOperation();
                    break;
                case 2:this.showAll();
                    break;
                case 3:
                    return;
            }

        }
    }
    //用户查询记录业务逻辑控制
    public void searchLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.searchMenu();
            int item= regex.menuItemValidate(1,7);
            switch (item){
                case 1:this.searchByName();
                    break;
                case 2:this.searchByAge();
                    break;
                case 3:this.searchBySex();
                    break;
                case 4:this.searchByTelNum();
                    break;
                case 5:searchByAdd();
                    break;
                case 6:showAll();
                    break;
                case 7:
                    return;
            }
        }



    }
    //修改记录业务逻辑控制
    public void modifyLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.modifyMenu();
            int item= regex.menuItemValidate(1,3);
            switch (item){
                case 1:this.showAll();
                    break;
                case 2:this.modifyOperation();
                    break;
                case 3:
                    return;
            }
        }

    }
    //删除记录业务逻辑控制
    public void deleteLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.deleteMenu();
            int item = regex.menuItemValidate(1,4);
            switch (item){
                case 1:this.showAll();
                    break;
                case 2:this.deleteOperation();
                    break;
                case 3:this.deleteAllOperation();
                    break;
                case 4:
                    return;
            }

        }
    }
    //排序记录业务逻辑控制
    public void orderLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true){
            menu.orderMenu();
            int item = regex.menuItemValidate(1,5);
            switch (item){
                case 1:this.orderName();
                    break;
                case 2:this.orderAge();
                    break;
                case 3:this.orderSex();
                    break;
                case 4:this.showAll();
                    break;
                case 5:
                    return;
            }

        }
    }
    //添加新记录信息
    public void addOperation (){
//        System.out.println("添加新用户信息");
        TelNoteRegex regex = new TelNoteRegex();
        String name=regex.nameValidate();
        String age=regex.ageValidate();
        String sex = regex.sexValidate();
        String telNum = regex.StelNumValidate();
        String add=regex.addressValidate();
        Person person = new Person(name,age,sex,telNum,add);
        this.list.add(person);
        person.setId(list.size());
        SavePerson(person);
    }
    //查询全部记录
    public void showAll(){
//        System.out.println("showAll");
        if (this.list.size()==0){
            System.out.println("没有任何记录");

        }
        else{
            for (Person l:list){
                System.out.println(l);
            }
        }
    }
    //按姓名查询记录
    public void searchByName(){
//        System.out.println("seatchByName");
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        serchByAny(name,"name");
    }
    //按年龄查询记录
    public void searchByAge(){
//        System.out.println("searchByAge");
        TelNoteRegex regex = new TelNoteRegex();
        String age = regex.ageValidate();
        serchByAny(age,"age");

    }
    //按性别查询记录
    public void searchBySex(){
//        System.out.println("searchBySex");
        TelNoteRegex regex = new TelNoteRegex();
        String sex = regex.sexValidate();
        serchByAny(sex,"sex");

    }
    //按电话号码查询记录
    public void searchByTelNum(){
//        System.out.println("searchByTelNum");
        TelNoteRegex regex = new TelNoteRegex();
        String tel = regex.StelNumValidate();
        serchByAny(tel,"tel");

    }
    //按地址查询记录
    public void searchByAdd(){
//        System.out.println("searchByAdd");
        TelNoteRegex regex = new TelNoteRegex();
        String add = regex.addressValidate();
        serchByAny(add,"add");

    }
// 将搜索方法抽取出来定义新的方法，传入搜索的内容 和 搜索的方式
    public void serchByAny(String byAny,String f){
        boolean flag =true;
        for (Person p:this.list){
            if (f=="name"){
                if (byAny.equals(p.getName())){
                    System.out.println(p);
                    flag=false;
                }
            }
            if (f=="age"){
                if (byAny.equals(p.getAge())){
                    System.out.println(p);
                    flag=false;
                }
            }
            if (f=="sex"){
                if (byAny.equalsIgnoreCase(p.getSex())){
                    System.out.println(p);
                    flag=false;
                }
            }
            if (f=="add"){
                if (byAny.equals(p.getAddress())){
                    System.out.println(p);
                    flag=false;
                }
            }
            if (f=="tle"){
                if (byAny.equalsIgnoreCase(p.getTleNum())){
                    System.out.println(p);
                    flag=false;
                }
            }

        }
            if(flag){
                System.out.println("查无此人");
            }
        }



    //修改指定记录
    public void modifyOperation(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        menu.subModifyMenu();
        int flag=regex.menuItemValidate(1,6);
        System.out.println("请输入需要修改记录的id");
        int itemNum=regex.menuItemValidate(1,this.list.size());
        switch (flag){
            case 1:String name = regex.nameValidate();
            this.list.get(itemNum-1).setName(name);
                break;
            case 2:String age = regex.ageValidate();
            this.list.get(itemNum-1).setAge(age);
                break;
            case 3:String sex = regex.sexValidate();
            this.list.get(itemNum-1).setSex(sex);
                break;
            case 4:String tel= regex.StelNumValidate();
            this.list.get(itemNum-1).setSex(tel);
                break;
            case 5:String add =regex.addressValidate();
            this.list.get(itemNum-1).setAddress(add);
                break;
            case 6:
                return;
        }
    }
    //删除指定记录
    public void deleteOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("输入删除的id");
        int item=regex.menuItemValidate(1,this.list.size());
        this.list.remove(item-1);
        for (int i=0;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }


    }
    //删除全部记录
    public void deleteAllOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        this.list.clear();
        System.out.println("全部清空");

    }
    //按用户姓名排序记录
    public void orderName(){
        Collections.sort(this.list,new OrderByname());
        for (int i=0 ;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
    }
    //按用户年龄排序记录
    public void orderAge(){
        Collections.sort(this.list,new OrderByAge());
        for (int i=0 ;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
    }
    //按性别排序记录
    public void orderSex(){
        Collections.sort(this.list,new OrderBysex());
        for (int i=0 ;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
    }

    //按姓名排序的比较器
    class OrderByname implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    //按年龄排序的比较器
    class OrderByAge implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }

    //按性别排序的比较器
    class OrderBysex implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getSex().compareTo(o2.getSex());
        }
    }

    //序列化
    public void SavePerson(Person person){
        ObjectOutputStream oos = null;
        try {
            oos=new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream("C:\\Users\\maoch\\IdeaProjects\\phonebook\\src\\com\\cydzs\\a.txt")));
            oos.writeObject(person);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //反序列化
    public Person readPerson(){
        ObjectInputStream ois =null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("C:\\Users\\maoch\\IdeaProjects\\phonebook\\src\\com\\cydzs\\a.txt")));
            Person person=(Person) ois.readObject();
            return person;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (ois!=null){
                    ois.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
     return null;
    }


}
