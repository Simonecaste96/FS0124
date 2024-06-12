export interface AuthData {
    accessToken: string,
    user: {
        name: string,
        id: number,
        email: string
    }
}
