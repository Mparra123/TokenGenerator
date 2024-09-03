package Business;

import Data.TokenGeneradorData;

public class TokenGeneratorBusiness {
    private final TokenGeneradorData tokenGeneradorData;


    public TokenGeneratorBusiness (){
        tokenGeneradorData = new TokenGeneradorData();
    }


    public String createToken(int upper,int lower,int digits, int special) {
        // Aquí puedes añadir lógica adicional, como validaciones, si es necesario.

        //hace connecion con capa datos.
        return tokenGeneradorData.generadorToken(upper,lower,digits,special);
    }
}
