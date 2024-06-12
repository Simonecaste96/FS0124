import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PostInterface } from 'src/app/models/post-interface';

@Injectable({
  providedIn: 'root',
})
export class PostsServiceService {
  apiURL =
    'https://bw3-gruppo6-default-rtdb.europe-west1.firebasedatabase.app/posts';
  constructor(private http: HttpClient) {}

  getPosts(): Observable<PostInterface[]> {
    return this.http.get<PostInterface[]>(`${this.apiURL}/.json`);
  }

  getPost(id: string): Observable<PostInterface> {
    return this.http.get<PostInterface>(`${this.apiURL}/${id}.json`);
  }

  createPost(body: PostInterface) {
    return this.http.post<any>(`${this.apiURL}/.json`, body);
  }

  updatePost(body: PostInterface, id: string) {
    return this.http.put<any>(`${this.apiURL}/${id}.json`, body);
  }
  deletePost(id: string) {
    return this.http.delete(`${this.apiURL}/${id}.json`);
  }
}
