import java.util.Scanner;

class Gora{
    String name; //название горы
    double height; //высота горы
    String location; //Место расположения горы
}

public class Main {
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);

        //Ввод информации о горах
        System.out.println("Введите количество гор:");
        int n=sc.nextInt(); //кол-во гор
        Gora mountain[]=new Gora[n];
        System.out.println("Введите информацию о горах:");
        for(int i=0; i < mountain.length; i++) {
            sc.nextLine();
            mountain[i]=new Gora();
            System.out.print("Название "+(i+1)+"-й горы: ");
            mountain[i].name=sc.nextLine();
            System.out.print("Место расположения "+(i+1)+"-й горы: ");
            mountain[i].location=sc.nextLine();
            System.out.print("Высота "+(i+1)+"-й горы: ");
            mountain[i].height=sc.nextDouble();
        }

        //Вывод полученной информации
        System.out.println("\nХарактеристики гор:");
        for(int i = 0; i< mountain.length; i++){
            System.out.println(""+mountain[i].name+"\t"+mountain[i].location+"\t"+mountain[i].height+" м.");
        }

        //Самая высокая вершина
        int nmax=0; //номер элемента для самой высокой вершины
        double max=mountain[nmax].height; //начальное значение максимальной высоты;

        for(int i=0; i < mountain.length; i++)
            if(mountain[i].height>max){
                max=mountain[i].height;
                nmax=i;
            }
        System.out.println("\nСамая высокая вершина:");
        System.out.println(""+mountain[nmax].name+"\t"+mountain[nmax].height+" м.");

        //Вершины с высотой более 1000 м.
        int h=1000;
        System.out.println("Вершины с высотой более 1000 м.:");
        for(int i=0; i < mountain.length; i++)
            if(mountain[i].height>h){
                System.out.println(mountain[i].name+"\t"+mountain[i].height+" м.");
            }

        //Сортировка гор по высоте
        for(int i=0; i < mountain.length; i++)
            for(int j=0; j < mountain.length-1-i; j++)
                if(mountain[j].height>mountain[j+1].height){
                    Gora p=mountain[j];
                    mountain[j]=mountain[j+1];
                    mountain[j+1]=p;
                }
        System.out.println("\nСписок гор по возрастанию высот:");
                for(int i=0; i < mountain.length; i++){
                    System.out.println(""+mountain[i].name+"\t"+mountain[i].height+" м.");
                }
        //Поиск по названию
        sc.nextLine();
        System.out.println("Введите название искомой горы:");
        String name=sc.nextLine();
        int nom=-1;

        for(int i=0; i < mountain.length; i++)
            if(name.equalsIgnoreCase(mountain[i].name))
                nom=i;
            if(nom!=-1){
                System.out.println("Такая гора есть в списке. Это "+mountain[nom].name);
            }
            else
                System.out.println("Такой горы нет в списке");
    }
}