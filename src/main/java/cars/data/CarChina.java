package cars.data;

import java.util.List;
import java.io.Serializable;

public class CarChina implements Serializable {
    private String id;

    private String 模型;
    private List<String> 标签;
    private String 燃料;

    private double 千米_总;
    private double 千米;
    private double 旅行_时候_总;
    private double 旅行_时候;

    private double 油_层次;
    private double 断裂_流畅_层次;
    private double 燃料_层次;

    private double 发动机;
    private double 休息;

    private double 胎压;

    public CarChina(String id, String 模型, List<String> 标签, String 燃料, double 千米_总, double 千米, double 旅行_时候_总,
            double 旅行_时候, double 油_层次, double 断裂_流畅_层次, double 燃料_层次, double 发动机, double 休息, double 胎压) {

        super();
        
        this.id = id;
        this.模型 = 模型;
        this.标签 = 标签;
        this.燃料 = 燃料;
        this.千米_总 = 千米_总;
        this.千米 = 千米;
        this.旅行_时候_总 = 旅行_时候_总;
        this.旅行_时候 = 旅行_时候;
        this.油_层次 = 油_层次;
        this.断裂_流畅_层次 = 断裂_流畅_层次;
        this.燃料_层次 = 燃料_层次;
        this.发动机 = 发动机;
        this.休息 = 休息;
        this.胎压 = 胎压;
    }

}
