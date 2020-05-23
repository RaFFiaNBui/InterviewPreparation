import java.time.LocalDateTime;

public class ST500Adapter implements MeteoSensor {

    private SensorTemperature sensorTemperature;

    public ST500Adapter(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public Float getTemperature() {
        return (float) sensorTemperature.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(sensorTemperature.year(), 1, 1, 0, 0, 0).plusDays(sensorTemperature.day() - 1).plusSeconds(sensorTemperature.second());
    }
}
