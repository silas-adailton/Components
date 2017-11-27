package br.com.autodoc.components.data.user;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.com.autodoc.components.model.UserFirebase;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class RepositoryFirebaseImpl implements RepositoryFirebase {

   private DatabaseReference databaseReference;

   @Inject
    public RepositoryFirebaseImpl(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    @Override
    public Observable<List<UserFirebase>> listMessage() {
        List<UserFirebase> list = new ArrayList<UserFirebase>();

        return Observable.create(new ObservableOnSubscribe<List<UserFirebase>>() {
            @Override
            public void subscribe(ObservableEmitter<List<UserFirebase>> emitter) throws Exception {
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        GenericTypeIndicator<Map<String, UserFirebase>> typeIndicator = new GenericTypeIndicator<Map<String, UserFirebase>>() {
                        };
                        Map<String, UserFirebase> map = dataSnapshot.getValue(typeIndicator);


                        for (String key : map.keySet()) {
                            list.add(map.get(key));
                        }
                        emitter.onNext(list);
                        emitter.onComplete();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        emitter.onError(databaseError.toException());
                    }
                });

//                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        GenericTypeIndicator<Map<String, UserFirebase>> typeIndicator = new GenericTypeIndicator<Map<String, UserFirebase>>() {
//                        };
//                        Map<String, UserFirebase> map = dataSnapshot.getValue(typeIndicator);
//
//
//                        for (String key : map.keySet()) {
//                            list.add(map.get(key));
//                        }
//                        emitter.onNext(list);
//                        emitter.onComplete();
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                        emitter.onError(databaseError.toException());
//
//                    }
//                });

            }
        });
    }

    @Override
    public Flowable<List<UserFirebase>> listUser() {
        List<UserFirebase> list = new ArrayList<UserFirebase>();

        return Flowable.create(new FlowableOnSubscribe<List<UserFirebase>>() {
            @Override
            public void subscribe(FlowableEmitter<List<UserFirebase>> e) throws Exception {
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        GenericTypeIndicator<Map<String, UserFirebase>> typeIndicator = new GenericTypeIndicator<Map<String, UserFirebase>>() {
                        };
                        Map<String, UserFirebase> map = dataSnapshot.getValue(typeIndicator);


                        for (String key : map.keySet()) {
                            list.add(map.get(key));
                        }
                        e.onNext(list);
                        e.onComplete();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
//                        emitter.onError(databaseError.toException());
                        e.onError(databaseError.toException());
                    }
                });
            }

//            @Override
//            public void subscribe(FlowableOnSubscribe<List<UserFirebase>> emitter) throws Exception {
//                databaseReference = FirebaseDatabase.getInstance().getReference("Users");
//
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        GenericTypeIndicator<Map<String, UserFirebase>> typeIndicator = new GenericTypeIndicator<Map<String, UserFirebase>>() {
//                        };
//                        Map<String, UserFirebase> map = dataSnapshot.getValue(typeIndicator);
//
//
//                        for (String key : map.keySet()) {
//                            list.add(map.get(key));
//                        }
//                        emitter.onNext(list);
////                        emitter.onComplete();
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        emitter.onError(databaseError.toException());
//                    }
//                });
//            }
        }, BackpressureStrategy.LATEST);

    }

}
