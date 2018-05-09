
package android.databinding;
import com.example.android.sunshine.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.android.sunshine.R.layout.activity_detail:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout-land/activity_detail_0".equals(tag)) {
                            return new com.example.android.sunshine.databinding.ActivityDetailBindingLandImpl(bindingComponent, view);
                    }
                    if ("layout/activity_detail_0".equals(tag)) {
                            return new com.example.android.sunshine.databinding.ActivityDetailBindingImpl(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_detail is invalid. Received: " + tag);
                }
                case com.example.android.sunshine.R.layout.primary_weather_info:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/primary_weather_info_0".equals(tag)) {
                            return new com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for primary_weather_info is invalid. Received: " + tag);
                }
                case com.example.android.sunshine.R.layout.extra_weather_details:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/extra_weather_details_0".equals(tag)) {
                            return new com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for extra_weather_details is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 597830097: {
                if(tag.equals("layout-land/activity_detail_0")) {
                    return com.example.android.sunshine.R.layout.activity_detail;
                }
                break;
            }
            case 257710925: {
                if(tag.equals("layout/activity_detail_0")) {
                    return com.example.android.sunshine.R.layout.activity_detail;
                }
                break;
            }
            case 98450412: {
                if(tag.equals("layout/primary_weather_info_0")) {
                    return com.example.android.sunshine.R.layout.primary_weather_info;
                }
                break;
            }
            case -19416940: {
                if(tag.equals("layout/extra_weather_details_0")) {
                    return com.example.android.sunshine.R.layout.extra_weather_details;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"};
    }
}