public class Plate {

    private PlatePosition platePosition;
    private int pixelHeightPosition;
    private int pixelWidthPosition;

    public Plate(PlatePosition platePosition, int pixelHeightPosition, int pixelWidthPosition) {
        this.platePosition = platePosition;
        this.pixelHeightPosition = pixelHeightPosition;
        this.pixelWidthPosition = pixelWidthPosition;
    }

    public PlatePosition getPlatePosition() {
        return platePosition;
    }

    public int getPixelHeightPosition() {
        return pixelHeightPosition;
    }

    public int getPixelWidthPosition() {
        return pixelWidthPosition;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "platePosition=" + platePosition +
                ", pixelHeightPosition=" + pixelHeightPosition +
                ", pixelWidthPosition=" + pixelWidthPosition +
                '}';
    }
}
