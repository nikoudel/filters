package filters;

import easyfit.IFilter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortableTime implements IFilter
{
    @Override
    public String apply(String s)
    {
        try
        {
            //e.g. /Date(1380036540000+0300)/
            Pattern p = Pattern.compile("^/Date\\((\\d+)\\+\\d+\\)/$");
            Matcher m = p.matcher(s);

            if (!m.matches()) return s;

            Date date = new Date(Long.parseLong(m.group(1)));

            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }
        catch(Exception ex)
        {
            return ex.getMessage();
        }
    }
}