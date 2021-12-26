package package_006;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Router {
    public int id;
    public List<Table> tableList;

    public Router(){
        tableList=new ArrayList<Table>();
    }

    public void printTable(){
        System.out.println("------------routTable of No "+id+"router is------------------");
        for (Table table : tableList) {
            System.out.println(table.hostId+" "+table.netId+"  "+table.distance+"  "+table.nextJumpId);
        }
    }
    public boolean isNearby(Router router){
        List<Table> tablesOther= router.tableList;
        for (Table table : tablesOther) {
            for (Table table2 : tableList) {
                if ((table.netId==table2.netId)&&(table.distance==1)&&(table2.distance==1)&&(table.hostId!=table2.hostId)) {
                    return true;//判断相邻的条件：两个路由器，对于相同的网络，都直接相连（距离为1）
                }
            }
        }
        return false;

    }
    public void init(int[][]near){//初始化问题：输入邻接矩阵，对每一个路由器，循环感知相连的网络
        tableList=new ArrayList<Table>();
        for (int i=0;i< near[id].length;i++)//对矩阵的第id行做循环,注意net编号是从0开始的
        {
            if (near[id][i]==1) {//id路由器和i号网络相连
                Table temptTable=new Table();
                temptTable.hostId=id;
                temptTable.netId=i;
                temptTable.distance=1;
                temptTable.nextJumpId=-1;//下一跳id为-1，表示直接交付

                tableList.add(temptTable);
            }
        }
    }

    public void send(Router router){//向指定路由器发送table,假设已知道二者相连

        router.update(tableList);//直接让对方更新自己的表就行了
    }

    public void update(List <Table> newList){
        java.util.Iterator<Table > iterator1= newList.iterator();


        while(iterator1.hasNext()) {//对于对方每一项，检查自己所有项
            Table table1= iterator1.next();//取出对方项
            List<Table>tempTableList=new ArrayList<Table>();//临时表，存储新增的项目
            int flag=0;//标志变量，记录是否找到相同目的地址的项
            java.util.Iterator<Table> iterator2=tableList.iterator();
            while (iterator2.hasNext()) {
                Table table2 = (Table) iterator2.next();//



                if (table2.netId==table1.netId) {
                    flag=1;
                    if (table2.nextJumpId==table1.hostId) {
                        table2.distance=table1.distance+1;
                    }
                    else {
                        if (table2.distance>table1.distance+1) {
                            //table2.hostId=id;
                            //table2.netId=table1.netId;
                            table2.nextJumpId=table1.hostId;
                            table2.distance=table1.distance+1;
                        }
                    }
                }


            }
            //自己的表遍历完了，如果flag还是0，才说明表中没有该项目
            if (flag==0) {
                flag=1;
                Table tempTable=new Table();
                tempTable.hostId=id;
                tempTable.netId=table1.netId;
                tempTable.nextJumpId=table1.hostId;
                tempTable.distance=table1.distance+1;

                tableList.add(tempTable);
            }

        }
        //打印当前路由表
        printTable();
    }
}
