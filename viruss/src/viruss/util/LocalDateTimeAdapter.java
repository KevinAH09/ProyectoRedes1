/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author ccarranza
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final Logger LOG = Logger.getLogger(LocalDateTimeAdapter.class.getName());

    @Override
    public LocalDateTime unmarshal(String dateString) throws Exception {

        try {
            if (dateString == null) {
                return null;
            }
            Instant instant = Instant.parse(dateString);
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            return dateTime;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al deserializar la fecha [" + dateString + "].", ex);
            throw ex;
        }

    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
        try {
            if (dateTime == null) {
                return null;
            }
            Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
            return DateTimeFormatter.ISO_INSTANT.format(instant);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al serializar la fecha [" + dateTime + "].", ex);
            throw ex;
        }
    }
}
