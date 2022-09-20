package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class AlarmTest {

    @Test
    void alarmIsOnWhenPressureIsTooLow() {
        Sensor sensor = probeValue(16);

        Alarm alarm = new Alarm();
        alarm.sensor=sensor;
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    private Sensor probeValue(double value) {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(value);
        return sensor;
    }

    private Sensor probeValue(double value, double value2) {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(value);
        return sensor;
    }

    @Test
    void alarmIsOnWhenPressureIsTooHigh() {
        Sensor sensor = probeValue(22);

        Alarm alarm = new Alarm();
        alarm.sensor=sensor;
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    void alarmStaysOffWhenPressureIsOkay(){
        Sensor sensor = probeValue(18);

        Alarm alarm = new Alarm();
        alarm.sensor=sensor;
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void alarmStaysOnWhenPressureIsOkay(){
        Sensor sensor = probeValue(12.0,22.0);

        Alarm alarm = new Alarm();
        alarm.sensor=sensor;
        alarm.check();
        assertTrue(alarm.isAlarmOn());

        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }


}