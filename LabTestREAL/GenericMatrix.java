package LabTestREAL;

public abstract class GenericMatrix<E extends Number>
{
    public abstract E[][] add(E[][] matrix1, E[][] matrix2);
    public abstract E[][] multiply(E[][] matrix1, E[][] nmatrix2);
    public abstract E zero();
    private E[][] matrix3;

    public <Thing> E[][] addMatrix(E[][] matrix1, E[][] matrix2)
    {
        if(matrix1.length != matrix2.length && matrix1[0].length != matrix2[0].length)
        {
            throw new RuntimeException("The matrices do not have the same size");
        }

        for(int i = 0; i < matrix1.length; i++)
        {
            for(int j = 0; j < matrix1[i].length; j++)
            {
                matrix3 = add(matrix1, matrix2);
            }
        }

        return matrix3;
    }

    public <Thing> E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2)
    {
        if(matrix1[0].length != matrix2.length)
        {
            throw new RuntimeException("The matrices do not have the same size");
        }

        for(int i = 0; i < matrix1.length; i++)
        {
            for(int j = 0; j < matrix1[0].length; j++)
            {
                matrix3 = multiply(matrix1, matrix2);
            }
        }

        return matrix3;
    }

    public <Thing> void printResult(E[][] matrix3)
    {
        for (int i = 0; i < matrix3.length; i++) 
        {
            for (int j = 0; j < matrix3[0].length; j++) 
            {
                System.out.print(matrix3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
