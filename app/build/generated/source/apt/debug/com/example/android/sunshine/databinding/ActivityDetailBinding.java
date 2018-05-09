package com.example.android.sunshine.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class ActivityDetailBinding extends ViewDataBinding {
    @Nullable
    public final com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding extraDetails;
    @Nullable
    public final com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding primaryInfo;
    // variables
    protected ActivityDetailBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , com.example.android.sunshine.databinding.ExtraWeatherDetailsBinding extraDetails1
        , com.example.android.sunshine.databinding.PrimaryWeatherInfoBinding primaryInfo1
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.extraDetails = extraDetails1;
        setContainedBinding(this.extraDetails);
        this.primaryInfo = primaryInfo1;
        setContainedBinding(this.primaryInfo);
    }
    //getters and abstract setters
    @NonNull
    public static ActivityDetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityDetailBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityDetailBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityDetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.example.android.sunshine.R.layout.activity_detail, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityDetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, com.example.android.sunshine.R.layout.activity_detail, null, false, bindingComponent);
    }
    @NonNull
    public static ActivityDetailBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return (ActivityDetailBinding)bind(bindingComponent, view, com.example.android.sunshine.R.layout.activity_detail);
    }
}