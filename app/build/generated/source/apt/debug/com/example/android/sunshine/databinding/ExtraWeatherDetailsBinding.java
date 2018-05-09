package com.example.android.sunshine.databinding;
import com.example.android.sunshine.R;
import com.example.android.sunshine.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ExtraWeatherDetailsBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.horizontal_middle, 1);
        sViewsWithIds.put(R.id.humidity_label, 2);
        sViewsWithIds.put(R.id.humidity, 3);
        sViewsWithIds.put(R.id.pressure_label, 4);
        sViewsWithIds.put(R.id.pressure, 5);
        sViewsWithIds.put(R.id.wind_label, 6);
        sViewsWithIds.put(R.id.wind_measurement, 7);
    }
    // views
    @NonNull
    public final android.support.constraint.ConstraintLayout extraDetails;
    @NonNull
    public final android.support.constraint.Guideline horizontalMiddle;
    @NonNull
    public final android.widget.TextView humidity;
    @NonNull
    public final android.widget.TextView humidityLabel;
    @NonNull
    public final android.widget.TextView pressure;
    @NonNull
    public final android.widget.TextView pressureLabel;
    @NonNull
    public final android.widget.TextView windLabel;
    @NonNull
    public final android.widget.TextView windMeasurement;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ExtraWeatherDetailsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.extraDetails = (android.support.constraint.ConstraintLayout) bindings[0];
        this.extraDetails.setTag(null);
        this.horizontalMiddle = (android.support.constraint.Guideline) bindings[1];
        this.humidity = (android.widget.TextView) bindings[3];
        this.humidityLabel = (android.widget.TextView) bindings[2];
        this.pressure = (android.widget.TextView) bindings[5];
        this.pressureLabel = (android.widget.TextView) bindings[4];
        this.windLabel = (android.widget.TextView) bindings[6];
        this.windMeasurement = (android.widget.TextView) bindings[7];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ExtraWeatherDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ExtraWeatherDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ExtraWeatherDetailsBinding>inflate(inflater, com.example.android.sunshine.R.layout.extra_weather_details, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ExtraWeatherDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ExtraWeatherDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.android.sunshine.R.layout.extra_weather_details, null, false), bindingComponent);
    }
    @NonNull
    public static ExtraWeatherDetailsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ExtraWeatherDetailsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/extra_weather_details_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ExtraWeatherDetailsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}