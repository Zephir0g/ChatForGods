import {Injectable} from "@angular/core";

export const UserConfigSettings = {
  "user_token":"",
  "username":"",
  "theme":"light",
  "language":"en",
}

@Injectable({
  providedIn: 'root'
})
export class UserConfig {

    createUserConfig(){
      localStorage.setItem('user_config', JSON.stringify(UserConfigSettings));
    }

     getUserConfig(){
      try {
        return  JSON.parse(localStorage.getItem('user_config') || '{}');
      } catch (error) {
        return UserConfigSettings;
      }

    }

    getDefaultConfig(){
        return UserConfigSettings;
    }

    updateUserConfig(config: any){
      localStorage.removeItem('user_config')
      localStorage.setItem('user_config', JSON.stringify(config));
    }
}
