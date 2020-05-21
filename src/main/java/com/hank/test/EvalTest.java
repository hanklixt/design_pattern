package com.hank.test;
/**
 * @Description
 * @auther 李先涛
 * @create 2020-05-05 17:20
 */
public class EvalTest {



    private static final String hello="hello";


    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }

    private static int test() {
      int [] arrays={1,2,4,4,5,6,7};
      int j=0;
      retry:for (int i=0;i<3;i++){

       abc: for (j=0;j<arrays.length;j++){
            int array = arrays[j];
            System.out.println(array);
            if (array!=4){
//                continue retry;
                    continue abc;
            }else if (array==4){
                if (j!=3)
                continue retry;
            }

        }

      }
      return j;
    }




}

