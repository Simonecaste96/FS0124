export interface SignupRequestBody {
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  returnSecureToken: true;
}
