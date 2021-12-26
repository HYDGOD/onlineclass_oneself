package package_006;


import java.util.*;

public class RouterDevelop {
    public static void main(String[] args){
        System.out.println("请输入网络的个数");
        Scanner scanner=new Scanner(System.in);
        int netCount= scanner.nextInt();
        System.out.println("请输入路由器个数");
        Scanner scanner2 =new Scanner(System.in);
        int routerCount=scanner2.nextInt();



        Router []routerList=new Router[netCount];
        int [][] Matrix=new int[routerCount][netCount];



        System.out.println("请输入"+routerCount+"行"+netCount+"列的链接矩阵,行代表路由器序号，列代表网络序号，输入quit结束");


        Scanner sc=new Scanner(System.in);


        //建立一个可变型的StringBuffer，记录用户输入的字符
        StringBuffer sb=new StringBuffer(sc.nextLine());



        int i=0;
        while(!(("quit").equals(sb.toString().trim())))//判定是否为约定的终止输入字符串
        {
            //StringBuffer转化为String数组
            String[] ss=sb.toString().split(" ");
            for(int j=0;j<5;j++){
                Matrix[i][j]=Integer.parseInt(ss[j]);
            }
            i++;
            sb.setLength(0);
            sb.append(sc.nextLine());
        }

        //得到了m*n的矩阵matrix
        //根据链接矩阵初始化路由器
        scanner.close();
        scanner2.close();
        sc.close();
        for (int j = 0; j < Matrix.length; j++) {
            routerList[j]=new Router();
            routerList[j].id=j;
            routerList[j].init(Matrix);
        }


        while(true){
            for (int j1 = 0; j1 < Matrix.length; j1++) {
                for (int j2 = 0; j2 < Matrix.length; j2++) {
                    if (routerList[j2].isNearby(routerList[j1])) {
                        routerList[j2].send(routerList[j1]);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            }
        }

    }
}
