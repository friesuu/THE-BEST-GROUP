package LabTestREAL;

public class IntegerMatrix extends GenericMatrix<Integer>
{
    private Integer[][] matrix3, matrix2, matrix1;

    public IntegerMatrix(Integer[][] matrix1, Integer[][] matrix2)
    {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }
    @Override
    public Integer[][] add(Integer[][] matrix1, Integer[][] matrix2) 
    {
        matrix3 = new Integer[matrix1.length][matrix1[0].length];
        for(int i = 0; i < matrix1.length; i++)
        {
            for(int j = 0; j < matrix1[0].length; j++)
            {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix3;
    }
    
    @Override
    public Integer[][] multiply(Integer[][] matrix1, Integer[][] nmatrix2) 
    {
        matrix3 = new Integer[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) 
        { 
            for (int j = 0; j < matrix2[0].length; j++) 
            { 
                for (int k = 0; k < matrix2.length; k++) 
                {
                    matrix3[i][j] = matrix1[i][k] * matrix2[k][j];
                }
            } 
        } 

        return matrix3;
    }
    
    @Override
    public Integer zero() 
    {
        return 0;
    }

    public void print(Integer[][] matrix3)
    {
        for(int i = 0; i < matrix1.length; i++)
        {
            for(int j = 0; j < matrix1[i].length; j++)
            {
                System.out.println(matrix3[i][j]);
            }
        }
    }



}
