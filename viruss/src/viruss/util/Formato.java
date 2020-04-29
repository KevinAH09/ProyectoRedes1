/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viruss.util;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author ccarranza
 */
public class Formato {

    private static Formato INSTANCE = null;

    public DateTimeFormatter formatDateShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    public DateTimeFormatter formatDateMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    public DecimalFormat decimalFormat = new DecimalFormat("#,###,###,##0.00");

    private Formato() {
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (Formato.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Formato();
                }
            }
        }
    }

    public static Formato getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public TextFormatter twoDecimalFormat() {
        TextFormatter numericFormat = new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
            if (c.getControlNewText().contains(",")) {
                ParsePosition parsePosition = new ParsePosition(0);
                Object object = decimalFormat.parse(c.getControlNewText(), parsePosition);

                if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
                    return null;
                } else {
                    Pattern validDoubleText = Pattern.compile("^[0-9]*+(\\.[0-9]{0,2})?$");
                    if (validDoubleText.matcher(c.getControlNewText().replace(",", "")).matches()) {
                        return c;
                    } else {
                        return null;
                    }
                }
            } else {
                Pattern validDoubleText = Pattern.compile("^[0-9]*+(\\.[0-9]{0,2})?$");
                if (validDoubleText.matcher(c.getControlNewText().replace(",", "")).matches()) {
                    return c;
                } else {
                    return null;
                }
            }
        });
        return numericFormat;
    }

    public TextFormatter twoDecimalFormatLimite() {
        TextFormatter numericFormat = new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
//            if (maxLength > 0) {
//                if (((TextInputControl) c.getControl()).getLength() >= maxLength && !c.isDeleted()) {
//                    return null;
//                }
//                if (c.getText().length() > maxLength && !c.isDeleted()) {
//                    return null;
//                }
//            }
            if (c.getControlNewText().contains(",")) {
                ParsePosition parsePosition = new ParsePosition(0);
                Object object = decimalFormat.parse(c.getControlNewText(), parsePosition);

                if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
                    return null;
                } else {
                    Pattern validDoubleText = Pattern.compile("^[0-9]*+(\\.[0-9]{0,2})?$");
                    if (validDoubleText.matcher(c.getControlNewText().replace(",", "")).matches()) {
                        return c;
                    } else {
                        return null;
                    }
                }
            } else {
                Pattern validDoubleText = Pattern.compile("^[0-9]*+(\\.[0-9]{0,2})?$");
                if (validDoubleText.matcher(c.getControlNewText().replace(",", "")).matches()) {
                    return c;
                } else {
                    return null;
                }
            }
        });
        return numericFormat;
    }

    public TextFormatter integerFormat(Integer maxLength) {
        TextFormatter numericFormat = new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
            if (maxLength > 0) {
                if (((TextInputControl) c.getControl()).getLength() >= maxLength && !c.isDeleted()) {
                    return null;
                }
                if (c.getText().length() > maxLength && !c.isDeleted()) {
                    return null;
                }
            }
            Pattern validDoubleText = Pattern.compile("\\d+");
            if (validDoubleText.matcher(c.getControlNewText()).matches()) {
                return c;
            } else {
                return null;
            }
        });
        return numericFormat;
    }

    public TextFormatter cedulaFormat(Integer maxLength) {
        TextFormatter<String> cedulaFormat = new TextFormatter<>(c -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
            if (maxLength > 0) {
                if (((TextInputControl) c.getControl()).getLength() >= maxLength && !c.isDeleted()) {
                    return null;
                }
                if (c.getText().length() > maxLength && !c.isDeleted()) {
                    return null;
                }
            }
            c.setText(c.getText().replaceAll("[^a-zA-Z0-9-]", ""));
            if (c.getControlNewText().matches(".*-{2,}.*")) {
                return null;
            }
            return c;

        });
        return cedulaFormat;
    }

    public TextFormatter letrasFormat(Integer maxLength) {
        TextFormatter<String> letrasFormat = new TextFormatter<>(c -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
            if (maxLength > 0) {
                if (((TextInputControl) c.getControl()).getLength() >= maxLength && !c.isDeleted()) {
                    return null;
                }
                if (c.getText().length() > maxLength && !c.isDeleted()) {
                    return null;
                }
            }
            c.setText(c.getText().replaceAll("[^a-zA-Z ]", ""));
            if (c.getControlNewText().matches(".*\\s{2,}.*")) {
                return null;
            }
            return c;

        });
        return letrasFormat;
    }

    public TextFormatter emailFormat() {
        TextFormatter emailFormat = new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }
//            Pattern pattern = Pattern
//                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
            Pattern validMailText = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            if (validMailText.matcher(c.getControlNewText()).matches()) {
                return c;
            } else {
                return null;
            }
        });
        return emailFormat;

    }

    public TextFormatter maxLengthFormat(Integer length) {
        TextFormatter maxLengthFormat = new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }

            if (((TextInputControl) c.getControl()).getLength() >= length && !c.isDeleted()) {
                return null;
            }
            if (c.getText().length() > length && !c.isDeleted()) {
                return null;
            }
            return c;
        });
        return maxLengthFormat;
    }
}
