package io.github.othercorbit.buildtools.shapes;

public class Line extends Shape
{
    public double endpointAX;
    public double endpointAY;
    public double endpointAZ;
    public double endpointBX;
    public double endpointBY;
    public double endpointBZ;

    public Line(Node A, Node B)
    {
        super();

        this.endpointAX = A.posX;
        this.endpointAY = A.posY;
        this.endpointAZ = A.posZ;

        this.endpointBX = B.posX;
        this.endpointBY = B.posY;
        this.endpointBZ = B.posZ;
    }

    @Override
    public String toString()
    {
        return "Line Info:\n" +
                "Endpoint A: ( " + this.endpointAX + ", " + this.endpointAY + ", " + this.endpointAZ + " )\n" +
                "Endpoint B: ( " + this.endpointBX + ", " + this.endpointBY + ", " + this.endpointBZ + " )";
    }
}