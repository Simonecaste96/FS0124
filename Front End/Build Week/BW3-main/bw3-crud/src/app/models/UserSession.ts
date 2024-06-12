export class UserSession {
  constructor(
    public email: string,
    public id: string,
    private token: string,
    private expirationDate: Date
  ) {}
}
