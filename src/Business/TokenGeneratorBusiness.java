package Business;

import Data.TokenGeneradorData;

public class TokenGeneratorBusiness {
    private TokenGeneradorData tokenGeneradorData;


    public TokenGeneratorBusiness (){
        tokenGeneradorData = new TokenGeneradorData();
    }


    public String createToken(int length) {
        // Aquí puedes añadir lógica adicional, como validaciones, si es necesario.
        return tokenGeneradorData.generadorToken(length);
    }
}
