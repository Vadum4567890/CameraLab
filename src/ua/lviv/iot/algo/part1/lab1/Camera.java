package ua.lviv.iot.algo.part1.lab1;
//
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Camera {
    private String model;
    private String resolution;
    private double zoom;
    private String memoryCardType;
    private int photosCount;
    private static Camera defaultPrinter = new Camera();
    private static Camera instance= new Camera();

    public static Camera getInstance() {
        return instance;
    }

    private Camera(String model) {
        this.model = model;
    }

    public static Camera getInstance(String model) {
        if (instance == null) {
            instance = new Camera(model);
        }
        return instance;
    }


    public void resetZoom()
    {
        this.zoom = 1;
    }
    public void savePhoto()
    {
        this.photosCount +=1;
    }
    public void eraseMemory(){
        this.photosCount = 0;
    }
    public void changeSettings(String resolution, double zoom){
        this.resolution = resolution;
        this.zoom = zoom;
    }
    @Override
    public String toString() {
        return "Camera " +
                "model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", zoom=" + zoom +
                ", memoryCardType='" + memoryCardType + '\'' +
                ", photosCount=" + photosCount;
    }

    public static void main(String[] args) {
        Camera[] cameras = new Camera[4];
        cameras[0] = new Camera("Canon", "1920x1080", 2.5, "SD", 0);
        cameras[1] = new Camera();
        cameras[2] = getInstance();
        cameras[3] = getInstance();
        for (Camera camera : cameras) {
            System.out.println(camera.toString());
        }
    }
}