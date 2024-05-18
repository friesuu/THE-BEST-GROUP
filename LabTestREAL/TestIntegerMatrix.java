package LabTestREAL;

public class TestIntegerMatrix 
{
    public static void main(String[] args) 
    {
        Integer[][] matrix1 = {{1,2,3}, {4,5,6}};
        Integer[][] matrix2 = {{6,5}, {4, 3}, {2,1}};
        IntegerMatrix genericMatrix = new IntegerMatrix(matrix1, matrix2);

        for(int i = 0; i < genericMatrix.multiplyMatrix(matrix1, matrix2).length; i++)
        {
            for(int j = 0; j < genericMatrix.multiplyMatrix(matrix1, matrix2)[0].length; j++)
            {
                System.out.println(genericMatrix.multiplyMatrix(matrix1, matrix2)[i][j]);
            }
        }

        // Integer[][] matrix3 = genericMatrix.add(matrix1, matrix2);
        
        // //genericMatrix.addMatrix(matrix1, matrix2);
        // /*for(int i = 0; i < matrix1.length; i++)
        // {
        //     for(int j = 0; j < matrix1[i].length; j++)
        //     {
        //         System.out.println(matrix3[i][j]);
        //     }
        // }*/

        // genericMatrix.print(genericMatrix.addMatrix(matrix1, matrix2));
    }    
}
