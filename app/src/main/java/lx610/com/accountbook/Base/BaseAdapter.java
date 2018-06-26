package lx610.com.accountbook.Base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class BaseAdapter<V extends RecyclerView.ViewHolder,D> extends RecyclerView.Adapter {
    List<D> mDataList;
    int layoutResID;
    int currentPosition;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public BaseAdapter(List<D> Data,int ResId) {
        mDataList = Data;
        layoutResID=ResId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder baseViewHolder = null;
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        View view = mLayoutInflater.inflate(layoutResID,parent);
        baseViewHolder = createBaseViewHolder(view);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        currentPosition=position;
        bindData(holder, mDataList.get(position));

    }

    public abstract void bindData(RecyclerView.ViewHolder holder, D d);

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public int getLayoutPosition(){
        return currentPosition;
    }

    /**
     * if you want to use subclass of BaseViewHolder in the adapter,
     * you must override the method to create new ViewHolder.
     *
     * @param view view
     * @return new ViewHolder
     */
    @SuppressWarnings("unchecked")
    protected V createBaseViewHolder(View view) {
        Class temp = getClass();
        Class z = null;
        while (z == null && null != temp) {
            z = getInstancedGenericKClass(temp);
            temp = temp.getSuperclass();
        }
        V k = createGenericKInstance(z, view);
        return null != k ? k : (V) new com.chad.library.adapter.base.BaseViewHolder(view);
    }

    /**
     * get generic parameter K
     *
     * @param z
     * @return
     */
    private Class getInstancedGenericKClass(Class z) {
        Type type = z.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            for (Type temp : types) {
                if (temp instanceof Class) {
                    Class tempClass = (Class) temp;
                    if (com.chad.library.adapter.base.BaseViewHolder.class.isAssignableFrom(tempClass)) {
                        return tempClass;
                    }
                }
            }
        }
        return null;
    }

    /**
     * try to create Generic K instance
     *
     * @param z
     * @param view
     * @return
     */
    @SuppressWarnings("unchecked")
    private V createGenericKInstance(Class z, View view) {
        try {
            Constructor constructor;
            // inner and unstatic class
            if (z.isMemberClass() && !Modifier.isStatic(z.getModifiers())) {
                constructor = z.getDeclaredConstructor(getClass(), View.class);
                constructor.setAccessible(true);
                return (V) constructor.newInstance(this, view);
            } else {
                constructor = z.getDeclaredConstructor(View.class);
                constructor.setAccessible(true);
                return (V) constructor.newInstance(view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder{
        View rootView;
        public BaseViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
        }

        public void setText(int ResId,String text){
            TextView textView = rootView.findViewById(ResId);
            textView.setText(text);
        }

        public View getView(int ResId){
           View view = rootView.findViewById(ResId);
           return view;
        }
    }
}
