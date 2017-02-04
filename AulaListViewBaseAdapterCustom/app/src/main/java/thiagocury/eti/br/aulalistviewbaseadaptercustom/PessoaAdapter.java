package thiagocury.eti.br.aulalistviewbaseadaptercustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by Alunos on 19/12/2016.
 */

public class PessoaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pessoa> pessoas;
    private LayoutInflater inflater;

    public PessoaAdapter(Context context,
                         ArrayList<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
        this.inflater = LayoutInflater.from(context);
    }//fecha construtor

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Pessoa getItem(int i) {
        return pessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder holder;
        if(view == null){
            view = inflater.inflate(R.layout.linha_pessoa,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }//fecha else

        Pessoa p = getItem(i);
        holder.tvNome.setText("Nome "+p.getNome());
        holder.tvSexo.setText("Sexo "+p.getSexo());
        holder.tvIdade.setText("Idade "+String.valueOf(p.getIdade()));

        if(p.getSexo().equalsIgnoreCase("Masculino")){
            Picasso.with(context)
                   .load("https://image.freepik.com/icones-gratis/homem-de-negocios-apontando-para-a-esquerda_318-62535.jpg") //URL IMAGEM MASCULINO
                   .placeholder(R.mipmap.ic_launcher)
                   .transform(new CropCircleTransformation())
                   .into(holder.ivSexo);
        }else{
            Picasso.with(context)
                    .load("http://images.gofreedownload.net/woman-28905.jpg") //URL IMAGEM FEMININO
                    .placeholder(R.mipmap.ic_launcher)
                    .transform(new CropCircleTransformation())
                    .into(holder.ivSexo);
        }//fecha else

        return view;
    }//fecha getView

    static class ViewHolder{
        private TextView tvNome;
        private TextView tvSexo;
        private TextView tvIdade;
        private ImageView ivSexo;
        public ViewHolder(View view) {
            tvNome=(TextView)view.findViewById(R.id.lp_tv_nome);
            tvSexo=(TextView) view.findViewById(R.id.lp_tv_sexo);
            tvIdade=(TextView) view.findViewById(R.id.lp_tv_idade);
            ivSexo=(ImageView) view.findViewById(R.id.lp_iv_sexo);
        }
    }
}//fecha classe
