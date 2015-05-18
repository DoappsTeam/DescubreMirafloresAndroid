package me.doapps.miraflores.fragments;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import me.doapps.miraflores.R;
import me.doapps.miraflores.util.GpsUtil;

/**
 * Created by doapps on 5/17/15.
 */
public class DetailFragment extends Fragment {
    private GoogleMap mMap;
    private SupportMapFragment mSupportMapFragment;
    GpsUtil gpsUtil;
    Marker markerTaxiDriver, markerEvent;

    double tempLat;
    double tempLng;

    public static DetailFragment newInstance(double lat, double lng) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("LAT", String.valueOf(lat));
        bundle.putString("LNG", String.valueOf(lng));
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gpsUtil = new GpsUtil(getActivity());
        FragmentManager mFragmentManager = getChildFragmentManager();
        mSupportMapFragment = (SupportMapFragment) mFragmentManager.findFragmentById(R.id.maps_map);
        if (mSupportMapFragment == null) {
            mSupportMapFragment = SupportMapFragment.newInstance();
            mFragmentManager.beginTransaction().replace(R.id.maps_map, mSupportMapFragment).commit();
        }

        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = mSupportMapFragment.getMap();
            if (mMap != null) {
                setUpMap();
            } else {
                Log.e("setUpMap", "2do else");
            }
        } else {
            setUpMap();
        }
    }

    private void setUpMap() {
        Location location = gpsUtil.getLocation();
        mMap.getUiSettings().setZoomControlsEnabled(false);
        if (location != null) {
            CameraPosition camPos = new CameraPosition.Builder()
                    .target(new LatLng(location.getLatitude(), location.getLongitude()))
                    .zoom(16)
                    .build();
            CameraUpdate initCam = CameraUpdateFactory.newCameraPosition(camPos);
            mMap.animateCamera(initCam);
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                    marker.showInfoWindow();
                    return true;
                }
            });

            markerTaxiDriver = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(location.getLatitude(), location.getLongitude()))
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_client)));
            markerEvent = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(-12.111373,-77.030002))
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            new RotaTask().execute(markerTaxiDriver.getPosition().latitude+","+
                            markerTaxiDriver.getPosition().longitude,
                    markerEvent.getPosition().latitude+","+markerEvent.getPosition().longitude);

        } else {
            CameraPosition camPos = new CameraPosition.Builder()
                    .target(new LatLng(0, 0))
                    .zoom(4)
                    .build();
            CameraUpdate initCam = CameraUpdateFactory.newCameraPosition(camPos);
            mMap.animateCamera(initCam);
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                    //marker.showInfoWindow();
                    return true;
                }
            });
            /*
            ((MenuActivity) getActivity()).markerTaxiDriver = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(0, 0))
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.im_taxi2)));
            textViewCurrenAddress.setText("");
            */
        }
    }

    public class RotaTask extends AsyncTask<String, Integer, Boolean> {
        private static final String TOAST_ERR_MAJ = "Impossible to trace Itinerary";

        //private GoogleMap gMap;
        private final ArrayList<LatLng> lstLatLng = new ArrayList<LatLng>();

        /*
        public void setMap(GoogleMap gMap){
            this.gMap = gMap;
        }
        */
        @Override
        protected void onPreExecute() {
            Log.e("RUN", "RUN");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
                PolylineOptions polylines = new PolylineOptions();
                //polylines.color(Color.parseColor("#2d2d2d"));
                polylines.color(getActivity().getResources().getColor(R.color.green));
                polylines.width(5);
                for (final LatLng latLng : lstLatLng) {
                    polylines.add(latLng);
                    Log.e("add","point");
                }
                mMap.addPolyline(polylines);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                final StringBuilder url = new StringBuilder("http://maps.googleapis.com/maps/api/directions/xml?sensor=false&language=pt");
                url.append("&origin=");
                url.append(params[0]);
                url.append("&destination=");
                url.append(params[1]);
                Log.e("url", url.toString());
                final InputStream stream = new URL(url.toString()).openStream();
                final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setIgnoringComments(true);
                final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                final Document document = documentBuilder.parse(stream);
                document.getDocumentElement().normalize();
                final String status = document.getElementsByTagName("status").item(0).getTextContent();
                if (!"OK".equals(status)) {
                    return false;
                }
                final Element elementLeg = (Element) document.getElementsByTagName("leg").item(0);
                final NodeList nodeListStep = elementLeg.getElementsByTagName("step");
                final int length = nodeListStep.getLength();
                for (int i = 0; i < length; i++) {
                    final Node nodeStep = nodeListStep.item(i);
                    if (nodeStep.getNodeType() == Node.ELEMENT_NODE) {
                        final Element elementStep = (Element) nodeStep;
                        decodePolylines(elementStep.getElementsByTagName("points").item(0).getTextContent());
                    }
                }
                return true;
            } catch (final Exception e) {
                return false;
            }


        }

        private void decodePolylines(final String encodedPoints) {
            int index = 0;
            int lat = 0, lng = 0;
            while (index < encodedPoints.length()) {
                int b, shift = 0, result = 0;
                do {
                    b = encodedPoints.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;
                shift = 0;
                result = 0;
                do {
                    b = encodedPoints.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;
                lstLatLng.add(new LatLng((double) lat / 1E5, (double) lng / 1E5));
            }
        }
    }
}
