package br.com.juliocnsouza.translator.parsing;

import br.com.juliocnsouza.translator.URLCONSTANTS;
import br.com.juliocnsouza.translator.parsing.utils.WebUtils;
import br.com.juliocnsouza.translator.text.Text;

public class ParseTextDetect implements Parse {

    private StringBuilder url;
    private Text input;

    public ParseTextDetect( Text input ) {
        this.input = input;
    }

    @Override
    public void appendURL() {

        url = new StringBuilder( URLCONSTANTS.GOOGLE_TRANSLATE_DETECT );
        url.append( "v=1.0&" );
        url.append( "q=" + input.getLanguage().replace( " " , "%20" ) );

    }

    @Override
    public void parse() {

        appendURL();
        String result = WebUtils.source( url.toString() );
        input.setLanguage( result.split( "," )[0].split( ":" )[2].replace( "\"" , "" ) );

    }

}
