/**
 * @author :Yeh-Wang
 * @date : 2022/10/27
 */

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class proInterface {
    public ArrayList<colEntity> col = new ArrayList<>();
    public ArrayList<entityOperation> list = new ArrayList<>();
    public proFunction fun = new proFunction();
    public Scanner scanner = new Scanner(System.in);

    public void showPanel() {
        int count = 0;
        while (count < 99) {
            String gather;
//输入集合元素并进行处理--------------------------------------------------------------------------------
            System.out.println("请输入集合元素:(使用”<>“或者”{}“包裹,元素间以半角逗号分隔)");
            gather = scanner.nextLine();
            int k = 1;
            for (int i = 1; i < gather.length(); i = i + 1) {
                colEntity data1 = new colEntity();
                if (gather.charAt(i) == ',' || gather.charAt(i) == '>' || gather.charAt(i) == '}') {
                    data1.setData(gather.substring(k, i));
                    k = i + 1;
                    col.add(data1);
                }
            }
            scanner.reset();
//输入*运算表并进行处理---------------------------------------------------------------------------------
            list = fun.setList(col);
            System.out.println("请输入集合元素:(使用”<>“或者”{}“包裹,元素间以半角逗号分隔)");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                gather = scanner.nextLine();
                list.get(i).setData(gather);
                scanner.reset();
            }
            fun.print(list,col);
//判断输出代数系统的运算性质，特殊元，类型--------------------------------------------------------------------
            if(fun.JudgeClosed(list)){
                System.out.println("该代数系统具有封闭的运算性质");
                if(fun.JudgeCommutation(list,col)){
                    System.out.println("该代数系统具有可交换的运算性质");
                } else {
                    System.out.println("该代数系统不具有可交换的运算性质");
                }
                if(fun.JudgeAssociative(list,col)){
                    System.out.println("该代数系统具有可结合的运算性质");
                } else {
                    System.out.println("该代数系统不具有可结合的运算性质");
                }
                if(fun.JudgeIdempotence(list,col)){
                    System.out.println("该代数系统具有等幂的运算性质");
                } else {
                    System.out.println("该代数系统不具有等幂的运算性质");
                }
                if(!Objects.equals(fun.JudgeIE(list, col), " ")){
                    System.out.println("该代数系统具有幺元:"+fun.JudgeIE(list,col));
                } else {
                    System.out.println("该代数系统不具有幺元");
                }
                if(!Objects.equals(fun.JudgeZero(list, col), " ")){
                    System.out.println("该代数系统具有零元:"+fun.JudgeZero(list,col));
                } else {
                    System.out.println("该代数系统不具有零元");
                }
                if(fun.JudgeInverse(list,col)){
                    System.out.println("该代数系统中集合中每个元素都存在相对应的逆元");
                } else {
                    System.out.println("该代数系统中不满足集合中每个元素都存在相对应的逆元");
                }
                if(fun.JudgeGroupoid(list,col)){
                    System.out.println("该代数系统是广群");
                } else {
                    System.out.println("该代数系统不是广群");
                }
                if(fun.JudgeSemi_Group(list,col)){
                    System.out.println("该代数系统是半群");
                } else {
                    System.out.println("该代数系统不是半群");
                }
                if(fun.JudgeMonoid(list,col)){
                    System.out.println("该代数系统是独异点");
                } else {
                    System.out.println("该代数系统不是独异点");
                }
                if(fun.JudgeGroup(list,col)){
                    System.out.println("该代数系统是群");
                } else {
                    System.out.println("该代数系统不是群");
                }
            } else {
                System.out.println("该代数系统不具有封闭的运算性质");
            }
            list.clear();
            col.clear();
            count++;
        }
    }
}
