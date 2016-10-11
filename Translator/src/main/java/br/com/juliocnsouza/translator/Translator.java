package br.com.juliocnsouza.translator;

import br.com.juliocnsouza.translator.parsing.Parse;
import br.com.juliocnsouza.translator.parsing.ParseTextDetect;
import br.com.juliocnsouza.translator.parsing.ParseTextTranslate;
import br.com.juliocnsouza.translator.text.Text;
import br.com.juliocnsouza.translator.text.TextTranslate;

public class Translator {

    private static Translator translator;

    private Translator() {
    }

    public synchronized static Translator getInstance() {

        if ( translator == null ) {
            translator = new Translator();
        }
        return translator;

    }

    public void translate( TextTranslate textTranslate ) {

        Parse parse = new ParseTextTranslate( textTranslate );
        parse.parse();

    }

    public String translate( String text , String languageInput ,
                             String languageOutput ) {

        Text input = new Text( text , languageInput );
        TextTranslate textTranslate = new TextTranslate( input , languageOutput );
        Parse parse = new ParseTextTranslate( textTranslate );
        parse.parse();
        return textTranslate.getOutput().getText();

    }

    public String detect( String text ) {

        Text input = new Text( text );
        Parse parse = new ParseTextDetect( input );
        parse.parse();
        return input.getLanguage();

    }

}
